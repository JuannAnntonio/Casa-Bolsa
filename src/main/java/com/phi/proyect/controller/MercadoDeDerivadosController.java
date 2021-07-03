package com.phi.proyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.service.VarFactoryService;
import com.phi.proyect.vo.ResponseApp;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/mercadoDeDerivadoss")
public class MercadoDeDerivadosController {

//	private final FuncionesService fsFuncionesService;
//	private final MercadoDeDerivadosService deDerivadosService;
//	private final ParametrosService params;

	@Autowired
	private VarFactoryService varFactoryService;

//	public MercadoDeDerivadosController(FuncionesService fsFuncionesService,
//			MercadoDeDerivadosService deDerivadosService, ParametrosService params) {
//		super();
//		this.fsFuncionesService = fsFuncionesService;
//		this.deDerivadosService = deDerivadosService;
//		this.params = params;
//	}

//	@RequestMapping(value = "/swaps", method = RequestMethod.POST)
//	public ResponseTransfer insertTvaluacionhoy() {
//		int resultFecha = deDerivadosService.updateFecha();
//		List<com.phi.proyect.models.DeSwap> lista = deDerivadosService.findAllDeSwap();
//		List<Parametros> listaparam = params.findParametro("PORCENTAJE");
//		int porce1 = 3;
//		int porce2 = 7;
//		int porce3 = 13;
//		if (listaparam.size() > 0) {
//			String porc = listaparam.get(0).getValorDelParametro();
//			String[] parts = porc.split("\\|");
//			porce1 = Integer.parseInt(parts[0]);
//			porce2 = Integer.parseInt(parts[1]);
//			porce3 = Integer.parseInt(parts[2]);
//		}
//
//		String fecha = deDerivadosService.findValueDate();
//		List<Tvaluacionhoy> list = new ArrayList<>();
//		List<Vista> listCal = new ArrayList<>();
//		int result = 0;
//		int result2 = 0;
//		Double resultado = (double) 0.0;
//		Double resultVar1 = (double) 0.0;
//		Double resultVar2 = (double) 0.0;
//		Double resultVar3 = (double) 0.0;
//		Date date2 = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String fecha2 = dateFormat.format(date2);
//		String f = deDerivadosService.findValueDate();
//		if (lista.size() > 0) {
//			for (int i = 0; i < lista.size(); i++) {
//				if (lista.get(i).getTpProducto() == 1) {
//					// resultado =
//					// fsFuncionesService.ValSwapStarting(lista.get(i).getCdTransaccion(),
//					// lista.get(i).getNuCurvaDescuento(), fecha);
//					// resultVar1 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),
//					// lista.get(i).getNuCurvaDescuento(),
//					// fecha,lista.get(i).getNuFlotante(),porce1);
//					// resultVar2 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),
//					// lista.get(i).getNuCurvaDescuento(),
//					// fecha,lista.get(i).getNuFlotante(),porce2);
//					// resultVar3 = fsFuncionesService.VaRSwapTiie(lista.get(i).getCdTransaccion(),
//					// lista.get(i).getNuCurvaDescuento(),
//					// fecha,lista.get(i).getNuFlotante(),porce3);
//				} else if (lista.get(i).getTpProducto() == 2) {
//					resultado = fsFuncionesService.ValSwap(lista.get(i).getCdTransaccion(),
//							lista.get(i).getNuCurvaDescuento(), lista.get(i).getNuFlotante(), fecha);
//
//					result = deDerivadosService.create(new Tvaluacionhoy(lista.get(i).getCdTransaccion(), resultado, 2,
//							f, resultVar1, resultVar2, resultVar3, 200));
//
//					resultVar1 = fsFuncionesService.varswap(porce1);
//					resultVar2 = fsFuncionesService.varswap(porce2);
//					resultVar3 = fsFuncionesService.varswap(porce3);
//				}
//
//				result = deDerivadosService.actualizarReg(new Tvaluacionhoy(lista.get(i).getCdTransaccion(), resultado,
//						2, f, resultVar1, resultVar2, resultVar3, 200));
//
//				list = deDerivadosService.findByInsertHistorico(lista.get(i).getCdTransaccion(), fecha2);
//
//				if (list.size() == 0) {
//					list = deDerivadosService.findByCdTransa(lista.get(i).getCdTransaccion());
//					if (list.size() == 0) {
//						result2 = deDerivadosService.createHistorico(new Tvaluacionhoy(lista.get(i).getCdTransaccion(),
//								resultado, 2, f, resultVar1, resultVar2, resultVar3, 200));
//					}
//				}
//
//			}
//
//		} else {
//			deDerivadosService.updateFechaRetoceso();
//			return new ResponseTransfer("No hay swaps que procesar");
//		}
//
//		List<DatosVar> listCalcu = deDerivadosService.getFechaCalculo(fecha2);
//
//		if (listCalcu.size() > 0) {
//			deDerivadosService.deleteCalculo(fecha2);
//		}
//
//		listCal = deDerivadosService.selectVista();
//
//		if (listCal.size() > 0) {
//			deDerivadosService.saveDeVarSwap(
//					new DatosVar(2, f, listCal.get(3).getPl(), listCal.get(8).getPl(), listCal.get(13).getPl()));
//		}
//
//		return new ResponseTransfer("Success");
//	}

	@PostMapping(value = "/generarVarFactory")
	public ResponseApp generarVarFactory(@RequestBody ObjectNode obj) {
		String fecha = obj.get("fecha").asText();
		System.out.println("### fecha :" + fecha);

		ResponseApp msj = varFactoryService.generarVarFactory(fecha);
		System.out.println("### MSJ :" + msj);
		return msj;
	}

	@PostMapping(value = "/validaGenerarVarFactory")
	public ResponseApp existenRegistros(@RequestBody ObjectNode obj) {
		String fecha = obj.get("fecha").asText();
		System.out.println("### fecha :" + fecha);

		ResponseApp msj = varFactoryService.existenCurvasByDate(fecha);
		System.out.println("### MSJ :" + msj);

		return msj;
	}

}
