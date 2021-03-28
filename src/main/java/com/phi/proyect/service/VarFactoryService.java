package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.phi.proyect.enums.InstrumentoEnum;
import com.phi.proyect.enums.MercadoEnum;
import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.models.CdMercado;
import com.phi.proyect.models.DatosVar;
import com.phi.proyect.models.DeDeuda;
import com.phi.proyect.models.DeForward;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.Parametros;
import com.phi.proyect.repository.CdMercadoRepository;
import com.phi.proyect.repository.DeForwardRepository;
import com.phi.proyect.repository.DeSwapRepository;
import com.phi.proyect.repository.HCurvasRepositiry;
import com.phi.proyect.repository.LnCurvasRepositiry;
import com.phi.proyect.repository.ValuacionHistoricoRepository;
import com.phi.proyect.vo.ResponseApp;

@Service
public class VarFactoryService {

	@Autowired
	private MercadoDeDerivadosService deDerivadosService;
	@Autowired
	private ParametrosService params;
	@Autowired
	private InstrumentoService instrumentoService;
	@Autowired
	private FuncionesService fsFuncionesService;
	@Autowired
	private DeSwapRepository deSwapRepository;
	@Autowired
	private DeDeudaService deDeudaService;
	@Autowired
	private DeForwardRepository deForwardRepository;
	@Autowired
	private CdMercadoRepository cdMercadoRepository;
	@Autowired
	private ValuacionHistoricoRepository valuacionHistoricoRepository;
	@Autowired
	private HCurvasRepositiry hCurvasRepository;
	@Autowired
	private LnCurvasRepositiry lnCurvaRepository;
	@Autowired
	private GraficaVarHistoricoService graficaService;

	private String fecha = "";
	private String usuario = "1";
	private int porce1 = 3;
	private int porce2 = 7;
	private int porce3 = 13;

	/*
	 * 
	 * Combo fecha *** - h_curvas y ln_curvas deben tener datos con la fecha
	 * seleccionada - Si no hay datos ...
	 * "No se encontraron registros de curvas para la fecha: "
	 * 
	 */
	public ResponseApp existenCurvasByDate(String fecha) {
		boolean hayDatos = hCurvasRepository.existsByDate(fecha) > 0 && lnCurvaRepository.existsByDate(fecha) > 0;
		if (!hayDatos) {
			return new ResponseApp(HttpStatus.NO_CONTENT, "No se encontraron registros de curvas para la fecha: "
					+ fecha + ", por favor intenta con otra fecha.");
		}
		return existenRegistros(fecha);
	}

	/*
	 * 
	 * - datos_var -> si existen datos con esa fecha, si hay, preguntar si los
	 * reemplaza? - delete datos_var con la fecha seleccionada
	 * 
	 */
	public ResponseApp existenRegistros(String fecha) {
		boolean hayDatos = deDerivadosService.existsByDate(fecha) > 0;
		if (hayDatos) {
			return new ResponseApp(HttpStatus.FOUND,
					"Se encontrarón datos con la fecha seleccionada. Desea continuar con el proceso.");
		}
		return generarVarFactory(fecha);
	}

	private void initPorceso(String fecha) {
		this.fecha = fecha;
		List<Parametros> listaparam = params.findParametro("PORCENTAJE");
		if (listaparam.size() > 0) {
			String porc = listaparam.get(0).getValorDelParametro();
			String[] parts = porc.split("\\|");
			porce1 = Integer.parseInt(parts[0]);
			porce2 = Integer.parseInt(parts[1]);
			porce3 = Integer.parseInt(parts[2]);
		}
	}

	public ResponseApp generarVarFactory(String fecha) {
		this.initPorceso(fecha);
		valuacionHistoricoRepository.deleteAll();
		deDerivadosService.deleteCalculo(fecha);
		graficaService.deleteByFecha(fecha);
		for (CdInstrumento instrumento : instrumentoService.getAllInstrumentos()) {

			if (InstrumentoEnum.SWAP_TIIE.getId().equals(instrumento.getIdInstrumento())
					|| InstrumentoEnum.SWAP_TIIE_SIDE.getId().equals(instrumento.getIdInstrumento())) {
				executeSwap(instrumento);
			} else if (InstrumentoEnum.BPAG.getId().equals(instrumento.getIdInstrumento())) {
				executeBpag(instrumento);
			} else if (InstrumentoEnum.BONOS_CORPORATIVOS.getId().equals(instrumento.getIdInstrumento())) {
				executeBonosCorporativos(instrumento);
			} else if (InstrumentoEnum.FORWARD.getId().equals(instrumento.getIdInstrumento())) {
				executeForward(instrumento);
			} else if (InstrumentoEnum.BONDES_D.getId().equals(instrumento.getIdInstrumento())) {
				executeBondesD(instrumento);
			} else if (InstrumentoEnum.BONOS_M.getId().equals(instrumento.getIdInstrumento())) {
				executeBonosM(instrumento);
			}

		}

		for (CdMercado mercado : cdMercadoRepository.findAll()) {
			if (mercado.getCdActivo().equals(1)) {
				insertMercado(mercado);
			} else {
				deDerivadosService
						.saveDatosVar(new DatosVar(0, "0", mercado.getIdMercado(), usuario, fecha, 0.0, 0.0, 0.0, 0.0));
			}
		}
		return new ResponseApp(HttpStatus.OK, "SUCCESS");
	}

	private void insertMercado(CdMercado mercado) {
		Double valuacion = fsFuncionesService.VaLRxMercado(mercado.getIdMercado(), 1, 1);
		Double var1 = fsFuncionesService.VaLRxMercado(mercado.getIdMercado(), porce1, 2);
		Double var2 = fsFuncionesService.VaLRxMercado(mercado.getIdMercado(), porce2, 2);
		Double var3 = fsFuncionesService.VaLRxMercado(mercado.getIdMercado(), porce3, 2);

		deDerivadosService.saveDatosVar(
				new DatosVar(0, "0", mercado.getIdMercado(), usuario, fecha, var1, var2, var3, valuacion));

		graficaService.insertaGraficaVarHistoricoM(1, porce1, mercado.getIdMercado(), fecha);// 99
		graficaService.insertaGraficaVarHistoricoM(2, porce2, mercado.getIdMercado(), fecha);// 97
		graficaService.insertaGraficaVarHistoricoM(3, porce3, mercado.getIdMercado(), fecha);// 95

	}

	private void executeSwap(CdInstrumento instrumento) {
		for (DeSwap swap : deSwapRepository.findByInstrumento(instrumento.getIdInstrumento())) {
			Double valuacion = fsFuncionesService.ValSwap(swap.getCdTransaccion(), swap.getNuFlotante(),
					swap.getNuCurvaDescuento(), fecha);

			callInsertaSwap(swap.getCdTransaccion(), swap.getNuFlotante(), swap.getNuCurvaDescuento(), fecha);

			Double var1 = fsFuncionesService.varswap(porce1);
			Double var2 = fsFuncionesService.varswap(porce2);
			Double var3 = fsFuncionesService.varswap(porce3);

			deDerivadosService.saveDatosVar(new DatosVar(instrumento.getIdInstrumento(), swap.getCdTransaccion(),
					MercadoEnum.Mercado_Derivado.getId(), usuario, fecha, var1, var2, var3, valuacion));

			valuacionHistoricoRepository.insertaValSwap();
		}
		insertInstrumento(instrumento.getIdInstrumento(), MercadoEnum.Mercado_Derivado);
	}

	private void callInsertaSwap(String cdTransaccion, Integer cdCurva, Integer cdDescuento, String fecha) {
		valuacionHistoricoRepository.insertaSwapUno(cdTransaccion, cdCurva, fecha);
		valuacionHistoricoRepository.insertaSwapDos(cdCurva, fecha);
		valuacionHistoricoRepository.insertaSwapTres(cdDescuento, fecha);
		valuacionHistoricoRepository.insertaSwapCuatro(cdCurva, fecha);
		valuacionHistoricoRepository.insertaSwapCinco(cdDescuento, fecha);
	}

	private void insertInstrumento(Integer idIntrumento, MercadoEnum mercado) {
		Double valuacion = fsFuncionesService.VaLRxInstrumento(idIntrumento, 1, 1);
		Double var1 = fsFuncionesService.VaLRxInstrumento(idIntrumento, porce1, 2);
		Double var2 = fsFuncionesService.VaLRxInstrumento(idIntrumento, porce2, 2);
		Double var3 = fsFuncionesService.VaLRxInstrumento(idIntrumento, porce3, 2);

		deDerivadosService.saveDatosVar(
				new DatosVar(idIntrumento, "Portafolio", mercado.getId(), usuario, fecha, var1, var2, var3, valuacion));

		graficaService.insertaGraficaVaRHistoricoP(1, porce1, idIntrumento, fecha);// 99
		graficaService.insertaGraficaVaRHistoricoP(2, porce2, idIntrumento, fecha);// 97
		graficaService.insertaGraficaVaRHistoricoP(3, porce3, idIntrumento, fecha);// 95

	}

	private void executeBpag(CdInstrumento instrumento) {
		for (DeDeuda deuda : deDeudaService.findBpagProcessVarFactory()) {
			auxiliarBpag(deuda, instrumento.getIdInstrumento());
		}
		insertInstrumento(instrumento.getIdInstrumento(), MercadoEnum.Mercado_Dinero);
	}

	private void executeBonosM(CdInstrumento instrumento) {
		for (DeDeuda deuda : deDeudaService.findBonosM()) {
			auxiliarBonosM(deuda, instrumento.getIdInstrumento());
		}
		insertInstrumento(instrumento.getIdInstrumento(), MercadoEnum.Mercado_Dinero);
	}

	private void executeBonosCorporativos(CdInstrumento instrumento) {
		for (DeDeuda deuda : deDeudaService.findBonosCorporativosProcessVarFactory()) {
			if (deuda.getCdAmortizable().equals(1)) {
				auxiliarBpag(deuda, instrumento.getIdInstrumento());
			} else if (deuda.getCdAmortizable().equals(2)) {
				auxiliarDeudaAmortizable(deuda, instrumento.getIdInstrumento());
			} else if (deuda.getCdAmortizable().equals(3)) {
				auxiliarBonosM(deuda, instrumento.getIdInstrumento());
			}
		}
		insertInstrumento(instrumento.getIdInstrumento(), MercadoEnum.Mercado_Dinero);
	}

	// valForward, varForward
	private void executeForward(CdInstrumento instrumento) {
		for (DeForward forward : deForwardRepository.findAll()) {

			Double valuacion = fsFuncionesService.ValForward(forward.getCdTransaccion().toString(),
					forward.getNuCurvaLocal(), forward.getNuCurvaForanea(), forward.getNuIndice(), fecha);
			Double var1 = fsFuncionesService.VaRForward(forward.getCdTransaccion().toString(),
					forward.getNuCurvaLocal(), forward.getNuCurvaForanea(), forward.getNuIndice(), fecha, porce1);
			Double var2 = fsFuncionesService.VaRForward(forward.getCdTransaccion().toString(),
					forward.getNuCurvaLocal(), forward.getNuCurvaForanea(), forward.getNuIndice(), fecha, porce2);
			Double var3 = fsFuncionesService.VaRForward(forward.getCdTransaccion().toString(),
					forward.getNuCurvaLocal(), forward.getNuCurvaForanea(), forward.getNuIndice(), fecha, porce3);

			deDerivadosService
					.saveDatosVar(new DatosVar(instrumento.getIdInstrumento(), forward.getCdTransaccion().toString(),
							MercadoEnum.Mercado_Derivado.getId(), usuario, fecha, var1, var2, var3, valuacion));

			valuacionHistoricoRepository.insertaValRForward(forward.getCdTransaccion().toString(),
					forward.getNuCurvaLocal(), forward.getNuCurvaForanea(), forward.getNuIndice(), fecha);
		}
		insertInstrumento(instrumento.getIdInstrumento(), MercadoEnum.Mercado_Derivado);

	}

	// ValBondes, VaRBondes
	// deuda.getCdCurva() es cdMercado??
	private void executeBondesD(CdInstrumento instrumento) {
		for (DeDeuda deuda : deDeudaService.findBondesD()) {
			Double valuacion = fsFuncionesService.ValBondes(deuda.getCdTransaccion());
			Double var1 = fsFuncionesService.VaRBondes(deuda.getCdTransaccion(), deuda.getCdSobretasa(),
					deuda.getCdCurva(), fecha, porce1);
			Double var2 = fsFuncionesService.VaRBondes(deuda.getCdTransaccion(), deuda.getCdSobretasa(),
					deuda.getCdCurva(), fecha, porce2);
			Double var3 = fsFuncionesService.VaRBondes(deuda.getCdTransaccion(), deuda.getCdSobretasa(),
					deuda.getCdCurva(), fecha, porce3);// TODO: deuda.getCdCurva() es cdMercado??

			deDerivadosService.saveDatosVar(new DatosVar(instrumento.getIdInstrumento(), deuda.getCdTransaccion(),
					MercadoEnum.Mercado_Dinero.getId(), usuario, fecha, var1, var2, var3, valuacion));

			valuacionHistoricoRepository.insertaValBondes(deuda.getCdTransaccion(), deuda.getCdSobretasa(),
					deuda.getCdCurva(), fecha);// TODO:deuda.getCdCurva() es cdMercado??
		}
		insertInstrumento(instrumento.getIdInstrumento(), MercadoEnum.Mercado_Dinero);
	}

	/**
	 * Metodos que se reutilizan en el proceso
	 */

	// valRevisables, varRevisables
	private void auxiliarBpag(DeDeuda deuda, Integer idInstrumento) {
		Double valuacion = fsFuncionesService.ValRevisables(deuda.getCdTransaccion());

		Double var1 = fsFuncionesService.VaRRevisables(deuda.getCdTransaccion(), deuda.getCdSobretasa(),
				deuda.getCdCurva(), fecha, porce1);
		Double var2 = fsFuncionesService.VaRRevisables(deuda.getCdTransaccion(), deuda.getCdSobretasa(),
				deuda.getCdCurva(), fecha, porce2);
		Double var3 = fsFuncionesService.VaRRevisables(deuda.getCdTransaccion(), deuda.getCdSobretasa(),
				deuda.getCdCurva(), fecha, porce3);

		valuacionHistoricoRepository.insertaValRevisables(deuda.getCdTransaccion(), deuda.getCdCurva(),
				deuda.getCdSobretasa(), fecha);
		deDerivadosService.saveDatosVar(new DatosVar(idInstrumento, deuda.getCdTransaccion(),
				MercadoEnum.Mercado_Dinero.getId(), usuario, fecha, var1, var2, var3, valuacion));

	}

	// valDeudaAmortizable,varDeuDeudaAmortizable
	private void auxiliarDeudaAmortizable(DeDeuda deuda, Integer idInstrumento) {
		Double valuacion = fsFuncionesService.ValDeudaAmortizable(deuda.getCdTransaccion(), fecha);

		Double var1 = fsFuncionesService.VaRDeudaAmortizable(deuda.getCdTransaccion(), deuda.getCdCurva(),
				deuda.getCdSobretasa(), fecha, porce1);
		Double var2 = fsFuncionesService.VaRDeudaAmortizable(deuda.getCdTransaccion(), deuda.getCdCurva(),
				deuda.getCdSobretasa(), fecha, porce2);
		Double var3 = fsFuncionesService.VaRDeudaAmortizable(deuda.getCdTransaccion(), deuda.getCdCurva(),
				deuda.getCdSobretasa(), fecha, porce3);

		deDerivadosService.saveDatosVar(new DatosVar(idInstrumento, deuda.getCdTransaccion(),
				MercadoEnum.Mercado_Dinero.getId(), usuario, fecha, var1, var2, var3, valuacion));

		valuacionHistoricoRepository.insertaValDeudaAmortizable(deuda.getCdTransaccion(), deuda.getCdCurva(),
				deuda.getCdSobretasa(), fecha);
	}

	// valBonosM, varBonosM
	private void auxiliarBonosM(DeDeuda deuda, Integer idInstrumento) {
		Double valuacion = fsFuncionesService.ValBonosM(deuda.getCdTransaccion());

		Double var1 = fsFuncionesService.VarBonosM(deuda.getCdTransaccion(), deuda.getCdCurva(), fecha, porce1);
		Double var2 = fsFuncionesService.VarBonosM(deuda.getCdTransaccion(), deuda.getCdCurva(), fecha, porce2);
		Double var3 = fsFuncionesService.VarBonosM(deuda.getCdTransaccion(), deuda.getCdCurva(), fecha, porce3);

		deDerivadosService.saveDatosVar(new DatosVar(idInstrumento, deuda.getCdTransaccion(),
				MercadoEnum.Mercado_Dinero.getId(), usuario, fecha, var1, var2, var3, valuacion));

		valuacionHistoricoRepository.insertaBonosM(deuda.getCdTransaccion(), deuda.getCdCurva(), fecha);
	}

}
