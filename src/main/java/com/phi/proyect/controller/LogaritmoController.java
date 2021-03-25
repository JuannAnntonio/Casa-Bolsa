package com.phi.proyect.controller;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.phi.proyect.algoritmos.Algoritmos;
import com.phi.proyect.models.DatosVar;
import com.phi.proyect.models.Logaritmo;
import com.phi.proyect.models.OperacionesMd;
import com.phi.proyect.models.ValuacionesMd;
import com.phi.proyect.models.VarLimite;
import com.phi.proyect.models.VarOperacionesMd;
import com.phi.proyect.models.Vector;
import com.phi.proyect.models.VectorPreciosDia;
import com.phi.proyect.repository.projection.DatosVarProjectionEntity;
import com.phi.proyect.service.DatosVarService;
import com.phi.proyect.service.LogaritmoService;
import com.phi.proyect.service.MercadoDeDerivadosService;
import com.phi.proyect.service.OperacionService;
import com.phi.proyect.service.ValuacionesMdService;
import com.phi.proyect.service.VarLimiteService;
import com.phi.proyect.service.VarOperacionesMdService;
import com.phi.proyect.service.VectorPreciosDiaService;
import com.phi.proyect.service.VectorService;
import com.phi.proyect.vo.MesadeDinero;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/logaritmo")
public class LogaritmoController {

	private final LogaritmoService log;
	private final VectorService vecSer;
	private final VectorPreciosDiaService vecpds;
	private final VarLimiteService varlimSer;
	private final ValuacionesMdService vs;
	private final OperacionService ops;
	private final VarOperacionesMdService vaOpMdSer;

	@Autowired
	private DatosVarService datosVarService;
	@Autowired
	private MercadoDeDerivadosService deDerivadosService;
	@Autowired
	private Algoritmos algoritmos;

	public LogaritmoController(LogaritmoService log, VectorService vecSer, VectorPreciosDiaService vecpds,
			VarLimiteService varlimSer, ValuacionesMdService vs, OperacionService ops,
			VarOperacionesMdService vaOpMdSer) {
		super();
		this.log = log;
		this.vecSer = vecSer;
		this.vecpds = vecpds;
		this.varlimSer = varlimSer;
		this.vs = vs;
		this.ops = ops;
		this.vaOpMdSer = vaOpMdSer;
	}

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", "Logaritmo");
		mav.setViewName("logaritmo");
		return mav;
	}

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	@ResponseBody
	public List<com.phi.proyect.vo.Logaritmo> lista(@RequestBody ObjectNode obj) {
		String descripcion = obj.get("descripcion").asText();
		String fecha = obj.get("fecha").asText();
		Double tasa = obj.get("tasa").asDouble();

		List<Logaritmo> parametro = log.findByDescripcion(descripcion);
		List<VectorPreciosDia> listaVectorDia = vecpds.findVectorPrecioDia(descripcion);
		List<com.phi.proyect.vo.Logaritmo> listReturn = new ArrayList<com.phi.proyect.vo.Logaritmo>();
		List<Double> logaritmos = new ArrayList<>();
		if (!parametro.isEmpty() && !listaVectorDia.isEmpty()) {
			String[] desc = parametro.get(0).getValorDelParametro().split("\\|");

			if (desc[1].equals("market_surcharge")) {
				List<Vector> listaValores = vecSer.findIssue(parametro.get(0).getDescripcion(),
						Integer.parseInt(desc[0]));
				int cont = 1;
				for (int i = 0; i < listaValores.size() - 1; i++) {
					float division = (listaValores.get(i).getMarketSurcharge()
							/ listaValores.get(cont).getMarketSurcharge());
					Double logaritmo = Math.log(division);

					if (Double.isNaN(logaritmo)) {
						logaritmo = 1.0; // lo puse porque en ocaciones viene con NaN
					}

					logaritmos.add(logaritmo);
					cont++;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaRegistro = sdf.parse(fecha, new ParsePosition(0));
				for (Double logaritmo : logaritmos) {
					Double calculaPrecio = algoritmos.CalculaPrecio(listaVectorDia.get(0), fechaRegistro,
							logaritmo + tasa);
					listReturn.add(new com.phi.proyect.vo.Logaritmo(logaritmo, calculaPrecio));
				}

				return listReturn;
			}
			return listReturn;
		}

		return listReturn;
	}

	@RequestMapping(value = "/log2", method = RequestMethod.POST)
	public List<VarOperacionesMd> lista2() {
		List<com.phi.proyect.vo.Logaritmo> listReturn = new ArrayList<com.phi.proyect.vo.Logaritmo>();
		List<OperacionesMd> lista = ops.findStatus();
		List<Double> logaritmos = new ArrayList<>();
		List<VarOperacionesMd> list = new ArrayList<>();

		for (int i = 0; i < lista.size(); i++) {
			List<Vector> listaValores = vecSer.findIssue(lista.get(i).getInstrumento(), 251);
			List<VectorPreciosDia> listaVectorDia = vecpds.findVectorPrecioDia(lista.get(i).getInstrumento());
			int cont = 1;
			for (int j = 0; j < listaValores.size() - 1; j++) {
				float division = (listaValores.get(j).getMarketSurcharge()
						/ listaValores.get(cont).getMarketSurcharge());
				Double logaritmo = Math.log(division);

				if (Double.isNaN(logaritmo)) {
					logaritmo = 1.0; // lo puse porque en ocaciones viene con NaN
				}

				logaritmos.add(logaritmo);
				cont++;
			}

			Date date = new Date();
			Double param1 = 0.0;
			Double param2 = 0.0;
			Double param3 = 0.0;
			for (Double logaritmo : logaritmos) {
				Double calculaPrecio = algoritmos.CalculaPrecio(listaVectorDia.get(0), date, logaritmo);
				listReturn.add(new com.phi.proyect.vo.Logaritmo(logaritmo, calculaPrecio));
				if (calculaPrecio > param1) {
					param1 = calculaPrecio;
				} else if (calculaPrecio > param2) {
					param2 = calculaPrecio;
				} else if (calculaPrecio > param3) {
					param3 = calculaPrecio;
				}
			}

			if (listaValores.size() > 0) {
				Date date2 = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String fecha = dateFormat.format(date2);
				createVarOperacionMd(lista.get(i).getInstrumento(), fecha, param1, param2, param3);
				list.add(new VarOperacionesMd(lista.get(i).getInstrumento(), fecha, param1, param2, param3));
			}

		}
		return list;
	}

	public ResponseEntity<VarOperacionesMd> createVarOperacionMd(String instrumento, String fecha, Double param1,
			Double param2, Double param3) {
		VarOperacionesMd varOperacionesMd = new VarOperacionesMd();
		varOperacionesMd.setInstrumento(instrumento);
		varOperacionesMd.setFecha(fecha);
		varOperacionesMd.setVarNoventaNueve(param1);
		varOperacionesMd.setVarNoventaSiete(param2);
		varOperacionesMd.setVarNoventaCinco(param3);
		return new ResponseEntity<>(this.vaOpMdSer.create(varOperacionesMd), HttpStatus.CREATED);
	}

	@PostMapping("/calcular/precio")
	public double calcular(@RequestBody ObjectNode obj) {
		String descripcion = obj.get("descripcion").asText();
		String fecha = obj.get("fecha").asText();
		Double tasa = obj.get("tasa").asDouble();

		List<VectorPreciosDia> lista = vecpds.findVectorPrecioDia(descripcion);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return algoritmos.CalculaPrecio(lista.get(0), sdf.parse(fecha, new ParsePosition(0)), tasa);

	}

	@GetMapping(value = "/mesaDinero")
	public List<MesadeDinero> mesaDinero() {
		List<com.phi.proyect.vo.MesadeDinero> listReturn = new ArrayList<com.phi.proyect.vo.MesadeDinero>();
		List<VectorPreciosDia> lista = vecpds.findAll();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String fechaEnvio = "" + formatter.format(date) + "";
		fechaEnvio = "2020-05-20";

		for (int i = 0; i < lista.size(); i++) {
			List<VarLimite> lista2 = varlimSer.findAll(lista.get(i).getIssue());
			List<ValuacionesMd> lista3 = vs.findValorLibros(lista.get(i).getIssue());
			List<VarOperacionesMd> lista4 = vaOpMdSer.findByFechaAndProducto(fechaEnvio, lista.get(i).getIssue());
			if (lista2.size() > 0) {

				Double valor = 0.0;
				Double multi = 0.0;

				Double valor1 = null;
				Double valor2 = null;
				Double valor3 = null;
				if (lista3.size() > 0) {
					valor = lista3.get(0).getValorEnLibros();
					multi = valor * Double.parseDouble(lista3.get(0).getTitulos());
				}

				if (lista4.size() > 0) {
					valor1 = lista4.get(0).getVarNoventaNueve();
					valor2 = lista4.get(0).getVarNoventaSiete();
					valor3 = lista4.get(0).getVarNoventaCinco();
				}

				listReturn.add(new com.phi.proyect.vo.MesadeDinero(lista.get(i).getIdValmerPriceVector(),
						lista.get(i).getIssue(), lista2.get(0).getLimite(), valor, multi, valor1, valor2, valor3));
			}
		}
		return listReturn;
	}

	@PostMapping(value = "/mesaDerivados")
	public List<Object> mesaDerivados(@RequestBody ObjectNode obj) {
		String fecha = getFecha(obj.get("fecha").asText());
		
		List<Object> retorno = new ArrayList<Object>();

		System.out.println("### fecha :" + fecha);
		List<VarLimite> varLimiteLista = varlimSer.findAll("2");
		// POSICION GLOBAL -> MERCADO = 1
		DatosVar posicionGlobal = datosVarService.findPosicionGlobalByFecha(fecha);
		// PRIMERA TABLA (MERCADOS)
		List<DatosVarProjectionEntity> mercados = datosVarService.findMercadosByFecha(fecha);

		retorno.add(null);
		retorno.add(varLimiteLista);// si
		retorno.add(posicionGlobal);// si
		retorno.add(fecha);// si
		retorno.add(mercados);// si

		return retorno;
	}

	@PostMapping(value = "/getProductos")
	public List<DatosVarProjectionEntity> getProductos(@RequestBody ObjectNode obj) {
		String idMercado = obj.get("idMercado").asText();
		String fecha = getFecha(obj.get("fecha").asText());;

		return datosVarService.findProductosByMercado(idMercado, fecha);
	}

	@PostMapping(value = "/getTransacciones")
	public List<DatosVar> getTransacciones(@RequestBody ObjectNode obj) {
		String idMercado = obj.get("idMercado").asText();
		String idInstrumento = obj.get("idInstrumento").asText();
		String fecha = getFecha(obj.get("fecha").asText());

		System.out.println("### idMercado :" + idMercado);
		System.out.println("### idInstrumento :" + idInstrumento);
		System.out.println("### fecha :" + fecha);

		return datosVarService.getTransacciones(idMercado, idInstrumento, fecha);
	}

	private String getFecha(String fecha) {
		String validateFecha = fecha;
		if(validateFecha==null || validateFecha.equals("")) {
			validateFecha = deDerivadosService.findValueDate();
		}
		System.out.println("### fecha :" + validateFecha);
		return validateFecha;
	}
}
