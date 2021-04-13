package com.phi.proyect.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.Caps;
import com.phi.proyect.models.CdCurvas;
import com.phi.proyect.models.CdInstrumento;
import com.phi.proyect.models.Curvas;
import com.phi.proyect.models.CurvasParametria;
import com.phi.proyect.models.DeCapsfloor;
import com.phi.proyect.models.DeDeuda;
import com.phi.proyect.models.DeForward;
import com.phi.proyect.models.DeFuturos;
import com.phi.proyect.models.DeSwap;
import com.phi.proyect.models.FlujosCapsfloor;
import com.phi.proyect.models.FlujosDeuda;
import com.phi.proyect.models.FlujosSwap;
import com.phi.proyect.models.HCurvas2;
import com.phi.proyect.models.PrimaryKeyFlujosDeuda;
import com.phi.proyect.models.PrimaryKeyFlujosSwaps;
import com.phi.proyect.repository.CdCurvasRepository;
import com.phi.proyect.repository.CdInstrumentoRepository;
import com.phi.proyect.repository.CsvRepository;
import com.phi.proyect.repository.CurvasParametriaRepository;
import com.phi.proyect.repository.CurvasRepository;
import com.phi.proyect.repository.DeCapsfloorRepository;
import com.phi.proyect.repository.DeDeudaRepository;
import com.phi.proyect.repository.DeForwardRepository;
import com.phi.proyect.repository.DeFuturosRepository;
import com.phi.proyect.repository.DeSwapRepository;
import com.phi.proyect.repository.FlujosCapsfloorRepository;
import com.phi.proyect.repository.FlujosDeudaRepository;
import com.phi.proyect.repository.FlujosSwapRepository;
import com.phi.proyect.repository.HCurvasRepositiry;
import com.phi.proyect.repository.HCurvasRepositiry2;

@Service
public class CsvService {

	private static final Logger log = LoggerFactory.getLogger(CsvService.class);
	
	@Autowired
	private CsvRepository csvRepo;
	@Autowired
	private HCurvasRepositiry curRepo;
	@Autowired
	private HCurvasRepositiry2 HcurRepo;
	@Autowired
	private CurvasRepository curvasRepo;
	@Autowired
	private CdCurvasRepository cdCurvasRepo;
	@Autowired
	private DeCapsfloorRepository deCapsFloorRepo;
	@Autowired
	private CdInstrumentoRepository cdIntrumentoRepo;
	@Autowired
	private FlujosCapsfloorRepository flujosCapsFloorRepo;
	@Autowired
	private DeSwapRepository deSwapRepo;
	@Autowired
	private FlujosSwapRepository flujosSwapRepo;
	@Autowired
	private DeFuturosRepository deFuturosRepo;
	@Autowired
	private CurvasParametriaRepository curvasParametros;
	@Autowired
	private DeForwardRepository forwardRepository;
	@Autowired
	private DeDeudaRepository deudaRepository;
	@Autowired
	private FlujosDeudaRepository flujosDeudaRepository;

	@Transactional
	public Caps create(Caps caps) {
		return this.csvRepo.save(caps);

	}

	public int existeFecha(String fecha) {
		return curRepo.existsByDate(fecha);
	}

	@Transactional
	public void deleteExisteFecha(String fecha) {
		this.HcurRepo.deleteMismaFecha(fecha);
		this.HcurRepo.deleteLnMismaFecha(fecha);

	}

	@Transactional
	public int createCurvasNuevo(double[] valores, int curva, String fecha) {
		return this.curRepo.insertHcurvasNuevo(curva, fecha, valores[0], valores[1], valores[2], valores[3], valores[4],
				valores[5], valores[6], valores[7], valores[8], valores[9], valores[10], valores[11], valores[12],
				valores[13], valores[14], valores[15], valores[16], valores[17], valores[18], valores[19], valores[20],
				valores[21], valores[22], valores[23], valores[24], valores[25], valores[26], valores[27], valores[28],
				valores[29], valores[30], valores[31], valores[32], valores[33], valores[34], valores[35], valores[36],
				valores[37], valores[38], valores[39], valores[40], valores[41], valores[42], valores[43], valores[44],
				valores[45], valores[46], valores[47], valores[48], valores[49], valores[50], valores[51], valores[52],
				valores[53], valores[54], valores[55], valores[56], valores[57], valores[58], valores[59], valores[60],
				valores[61], valores[62], valores[63], valores[64], valores[65], valores[66], valores[67], valores[68],
				valores[69], valores[70], valores[71], valores[72], valores[73], valores[74], valores[75], valores[76],
				valores[77], valores[78], valores[79], valores[80], valores[81], valores[82], valores[83], valores[84],
				valores[85], valores[86], valores[87], valores[88], valores[89], valores[90], valores[91], valores[92],
				valores[93], valores[94], valores[95], valores[96], valores[97], valores[98], valores[99], valores[100],
				valores[101], valores[102], valores[103], valores[104], valores[105], valores[106]);
	}

	public List<Curvas> findByFkCdCurva(int id) {
		return curvasRepo.findByFkCdCurva(id);
	}

	@Transactional
	public int saveCurvas(Curvas curvas) {
		return this.curvasRepo.save2(curvas.getFkCdCurva(), curvas.getFhDate(), curvas.getNuNodo(), curvas.getValor());
	}

	@Transactional
	public void DeleteAllCurvas() {
		curvasRepo.deleteAll();
	}

	public List<CdCurvas> findByCdCurva(int id) {
		return this.cdCurvasRepo.findByCdCurva(id);
	}

	@Transactional
	public int saveDeCapsFloor(DeCapsfloor deCapsfloor) {
		return this.deCapsFloorRepo.save2(deCapsfloor.getCdTransaccion(), deCapsfloor.getCdInstrumento(),
				deCapsfloor.getFhInicio(), deCapsfloor.getFhFin(), deCapsfloor.getNuCurvaDescuento(),
				deCapsfloor.getNuCurvaVolatilidad(), deCapsfloor.getNuStrike(), deCapsfloor.getTc(),
				deCapsfloor.getNuNominal(), deCapsfloor.getNuConvencion());
	}

	@Transactional
	public List<CdInstrumento> findByIdIntrumento(int id) {
		return this.cdIntrumentoRepo.findByFkIdInstrumento(id);
	}

	@Transactional
	public List<DeCapsfloor> findByCdTransaccion(String id) {
		return this.deCapsFloorRepo.findByCdTransaccion(id);
	}

	@Transactional
	public int saveFlujosCaps(FlujosCapsfloor flujosCapsfloor) {
		return this.flujosCapsFloorRepo.save2(flujosCapsfloor.getCdTransaccion(), flujosCapsfloor.getNuPago(),
				flujosCapsfloor.getFhPago(), flujosCapsfloor.getNuMontoPago(), flujosCapsfloor.getNuPlazoCupon(),
				flujosCapsfloor.getNuTasaVigente(), flujosCapsfloor.getCdActivo());
	}

	@Transactional
	public int saveDeSwap(DeSwap deSwap) {
		Integer numRegistros = deSwapRepo.findByTransaccion(deSwap.getCdTransaccion());
		if (numRegistros != null && numRegistros >= 1) {
			deSwapRepo.deleteAll(deSwap.getCdTransaccion());
		}
		DeSwap save = deSwapRepo.save(deSwap);
		return save != null ? 1 : 0;
	}

	@Transactional
	public void deleteFlujosSwap(FlujosSwap flujosSwap) {
		PrimaryKeyFlujosSwaps pk = new PrimaryKeyFlujosSwaps();
		pk.setCdTransaccion(flujosSwap.getCdTransaccion());
		pk.setNuPago(flujosSwap.getNuPago());
		if (this.flujosSwapRepo.existsById(pk)) {
			this.flujosSwapRepo.deleteById(pk);
		}
	}

	@Transactional
	public int saveFlujosSwap(FlujosSwap flujosSwap) {
		FlujosSwap save = flujosSwapRepo.save(flujosSwap);
		return save != null ? 1 : 0;
	}

	@Transactional
	public boolean saveForward(DeForward forward) {
		DeForward save = this.forwardRepository.save(forward);
		return this.forwardRepository.existsById(save.getCdTransaccion());
	}

	@Transactional
	public void deleteForward(DeForward forward) {
		if (this.forwardRepository.existsById(forward.getCdTransaccion())) {
			this.forwardRepository.deleteById(forward.getCdTransaccion());
		}
	}

	@Transactional
	public boolean saveDeuda(DeDeuda deuda) {
		DeDeuda save = this.deudaRepository.save(deuda);
		return this.deudaRepository.existsById(save.getCdTransaccion());
	}

	@Transactional
	public void deleteDeuda(DeDeuda deuda) {
		if (this.deudaRepository.existsById(deuda.getCdTransaccion())) {
			this.deudaRepository.deleteById(deuda.getCdTransaccion());
		}
	}

	@Transactional
	public boolean saveFlujosDeuda(FlujosDeuda flujosDeuda) {
		FlujosDeuda save = this.flujosDeudaRepository.save(flujosDeuda);
		PrimaryKeyFlujosDeuda pk = new PrimaryKeyFlujosDeuda(save.getCdTransaccion(), save.getNuFlujo());
		return this.flujosDeudaRepository.existsById(pk);
	}

	@Transactional
	public void deleteFlujosDeuda(FlujosDeuda flujosDeuda) {
		PrimaryKeyFlujosDeuda pk = new PrimaryKeyFlujosDeuda(flujosDeuda.getCdTransaccion(), flujosDeuda.getNuFlujo());
		if (this.flujosDeudaRepository.existsById(pk)) {
			this.flujosDeudaRepository.deleteById(pk);
		}
	}

	@Transactional
	public List<DeFuturos> findByCodigoDeTransaccion(int id) {
		return this.deFuturosRepo.findByCodigoDeTransaccion(id);
	}

	@Transactional
	public DeFuturos createDeFuturos(DeFuturos deFuturos) {
		return this.deFuturosRepo.save(deFuturos);

	}

	@Transactional
	public List<HCurvas2> getUltimoRegistro(int curva) {
		return this.HcurRepo.getUltimoRegistro(curva);
	}

	@Transactional
	public int deleteUltimoRegistro(String fecha, int curva) {
		this.HcurRepo.setSafeMode();
		return this.HcurRepo.deleteUltimo(fecha, curva);
	}

	@Transactional
	public List<Curvas> getResultados() {
		return this.curvasRepo.getRegistros();
	}

	@Transactional
	public int deleteAllCurvas() {
		this.HcurRepo.setSafeMode();
		this.curvasRepo.deleteAll();
		return 0;
	}

	@Transactional
	public List<FlujosSwap> getResultadosFlujosSwap() {
		return this.flujosSwapRepo.getRegistros();
	}

	@Transactional
	public int deleteDeSwap() {
		this.HcurRepo.setSafeMode();
		this.deSwapRepo.deleteAllsSwap();

		return 0;
	}

	@Transactional
	public int deleteFlujosSwap() {
		this.HcurRepo.setSafeMode();
		this.flujosSwapRepo.deleteAllFlujos();
		return 0;
	}

	@Transactional
	public List<CurvasParametria> getCurvasParametria() {
		return this.curvasParametros.curvasParametria();
	}

	@Transactional
	public int deleteHcurvas(String fecha) {
		this.HcurRepo.setSafeMode();
		this.HcurRepo.deleteMismaFecha(fecha);
		return 1;
	}

	public void insertaLn(String LnFechaUno, Date LnFechaDos) {
		System.out.println("### insertaLn");
		System.out.println(LnFechaUno);
		System.out.println(LnFechaDos);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(LnFechaDos);

		this.HcurRepo.insertaLn(LnFechaUno, format);
	}
}