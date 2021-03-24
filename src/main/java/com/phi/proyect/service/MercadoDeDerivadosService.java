package com.phi.proyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phi.proyect.models.DatosVar;
import com.phi.proyect.models.Tvaluacionhoy;
import com.phi.proyect.models.Vista;
import com.phi.proyect.repository.CalculoDeVarSwapRepository;
import com.phi.proyect.repository.DeSwapRepository2;
import com.phi.proyect.repository.HCurvasRepositiry2;
import com.phi.proyect.repository.MercadoDeDerivadosRepository;
import com.phi.proyect.repository.TvaluacionhoyRepository;
import com.phi.proyect.repository.VistaRepository;

@Service
@Transactional(readOnly = true)
public class MercadoDeDerivadosService {

	@Autowired
	private DeSwapRepository2 deSwapRepo2;
	@Autowired
	private MercadoDeDerivadosRepository MercadoDeRepo;
	@Autowired
	private TvaluacionhoyRepository tvalRepo;
	@Autowired
	private CalculoDeVarSwapRepository calRepo;
	@Autowired
	private VistaRepository vista;
	@Autowired
	private HCurvasRepositiry2 HcurRepo;

	@Transactional
	public List<com.phi.proyect.models.DeSwap2> findAllDeSwap() {
		return this.deSwapRepo2.findAll();
	}

	@Transactional
	public String findValue() {
		return this.MercadoDeRepo.getValue();
	}

	@Transactional
	public String findValueDate() {
		return this.MercadoDeRepo.getValueDate();
	}

	@Transactional
	public int create(Tvaluacionhoy tvaluacionhoy) {
		return this.tvalRepo.save2(tvaluacionhoy.getCdTransaccion(), tvaluacionhoy.getValuacion(),
				tvaluacionhoy.getCdInstrumento(), tvaluacionhoy.getFecha(), tvaluacionhoy.getVar1(),
				tvaluacionhoy.getVar2(), tvaluacionhoy.getVar3(), tvaluacionhoy.getPortafolio());

	}

	@Transactional
	public int actualizarReg(Tvaluacionhoy tvaluacionhoy) {
		this.tvalRepo.actualizarRegistro(tvaluacionhoy.getCdTransaccion(), tvaluacionhoy.getFecha(),
				tvaluacionhoy.getVar1(), tvaluacionhoy.getVar2(), tvaluacionhoy.getVar3());
		return 0;
	}

	@Transactional
	public int createHistorico(Tvaluacionhoy tvaluacionhoy) {
		return this.tvalRepo.save3(tvaluacionhoy.getCdTransaccion(), tvaluacionhoy.getValuacion(),
				tvaluacionhoy.getCdInstrumento(), tvaluacionhoy.getVar1(), tvaluacionhoy.getVar2(),
				tvaluacionhoy.getVar3(), tvaluacionhoy.getPortafolio(), tvaluacionhoy.getFecha());

	}

	@Transactional
	public void DeleteAll() {
		tvalRepo.deleteAll();
	}

	public List<Tvaluacionhoy> findByInsertHistorico(String cdTransaccion, String fecha) {
		return tvalRepo.findByInsertHistorico(cdTransaccion, fecha);
	}

	public List<Tvaluacionhoy> findByCdTransa(String cdTransaccion) {
		return tvalRepo.findByCdTransa(cdTransaccion);
	}

	public List<Vista> selectVista() {
		return vista.selectVista();
	}

	@Transactional
	public int saveDeVarSwap(DatosVar cal) {
		return this.calRepo.saveDeVarSwap(cal.getCdInstrumento(), cal.getFecha(), cal.getVar1(), cal.getVar2(),
				cal.getVar3());
	}

	@Transactional
	public Integer saveDatosVar(DatosVar datosVar) {
		return this.calRepo.saveDatosVar(datosVar.getCdMercado(), datosVar.getCdInstrumento(),
				datosVar.getCdTransaccion(), datosVar.getCdUsuario(), datosVar.getFecha(), datosVar.getVar1(),
				datosVar.getVar2(), datosVar.getVar3(), datosVar.getValuacion());
	}

	@Transactional
	public List<DatosVar> getFechaCalculo(String fecha) {
		return this.calRepo.findByFecha(fecha);

	}

	@Transactional
	public void deleteCalculo(String fecha) {
		this.calRepo.setSafeMode();
		this.calRepo.deleteUltimo(fecha);
	}

	@Transactional
	public int updateFecha() {
		this.HcurRepo.setSafeMode();
		return this.HcurRepo.updateFecha();
	}

	@Transactional
	public int updateFechaRetoceso() {
		this.HcurRepo.setSafeMode();
		return this.HcurRepo.updateFechaRetoceso();
	}

	@Transactional(readOnly = true)
	public Integer existsByDate(String fecha) {
		return calRepo.existsByDate(fecha);
	}

	private Boolean valueBoolean(Boolean valor) {
		if (null == valor) {
			return false;
		}
		return valor;
	}

}
