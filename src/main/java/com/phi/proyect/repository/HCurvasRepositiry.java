package com.phi.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phi.proyect.models.HCurvas;

public interface HCurvasRepositiry extends JpaRepository<HCurvas, Integer> {
//	@Modifying
//	@Query(value="INSERT INTO h_curvas (Cd_Curva,Fh_Date,N1,N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22, N23, N24, N25, N26, N27, N28) VALUES( :curva, :fecha, :p1, :p2, :p3, :p4, :p5, :p6, :p7, :p8, :p9, :p10, :p11, :p12, :p13, :p14, :p15, :p16, :p17, :p18, :p19, :p20, :p21, :p22, :p23, :p24, :p25, :p26, :p27, :p28)", nativeQuery =  true)
//	int save2(@Param("curva") int curva,@Param("fecha") String fecha,@Param("p1") double p1,@Param("p2") double p2,@Param("p3") double p3,@Param("p4") double p4, @Param("p5") double p5,@Param("p6") double p6,@Param("p7") double p7,@Param("p8") double p8,@Param("p9") double p9,@Param("p10") double p10,@Param("p11") double p11,@Param("p12") double p12,@Param("p13") double p13,@Param("p14") double p14,@Param("p15") double p15,@Param("p16") double p16,@Param("p17") double p17,@Param("p18") double p18,@Param("p19") double p19,@Param("p20") double p20,@Param("p21") double p21,@Param("p22") double p22,@Param("p23") double p23,@Param("p24") double p24,@Param("p25") double p25,@Param("p26") double p26,@Param("p27") double p27,@Param("p28") double p28);
//	

	@Modifying
	@Query(value = "INSERT INTO h_curvas VALUES ( :curva, :fecha, :p1, :p2, :p3, :p4, :p5, :p6, :p7, :p8, :p9, :p10, :p11, :p12, :p13, :p14, :p15, :p16, :p17, :p18, :p19, :p20, :p21, :p22, :p23, :p24, :p25, :p26, :p27, :p28  , :p29	, :p30	, :p31	, :p32	, :p33	, :p34	, :p35	, :p36	, :p37	, :p38	, :p39	, :p40	, :p41	, :p42	, :p43	, :p44	, :p45	, :p46	, :p47	, :p48	, :p49	, :p50	, :p51	, :p52	, :p53   , :p54	, :p55	, :p56	, :p57	, :p58	, :p59	, :p60	, :p61	, :p62	, :p63	, :p64	, :p65	, :p66	, :p67	, :p68	, :p69	, :p70	, :p71	, :p72	, :p73	, :p74	, :p75	, :p76	, :p77	, :p78	, :p79	, :p80  , :p81	, :p82	, :p83	, :p84	, :p85	, :p86	, :p87	, :p88	, :p89	, :p90	, :p91	, :p92	, :p93	, :p94	, :p95	, :p96	, :p97	, :p98	, :p99	, :p100	, :p101	, :p102	, :p103	, :p104	, :p105	, :p106	, :p107)", nativeQuery = true)
	int insertHcurvasNuevo(@Param("curva") int curva, @Param("fecha") String fecha, @Param("p1") double p1,
			@Param("p2") double p2, @Param("p3") double p3, @Param("p4") double p4, @Param("p5") double p5,
			@Param("p6") double p6, @Param("p7") double p7, @Param("p8") double p8, @Param("p9") double p9,
			@Param("p10") double p10, @Param("p11") double p11, @Param("p12") double p12, @Param("p13") double p13,
			@Param("p14") double p14, @Param("p15") double p15, @Param("p16") double p16, @Param("p17") double p17,
			@Param("p18") double p18, @Param("p19") double p19, @Param("p20") double p20, @Param("p21") double p21,
			@Param("p22") double p22, @Param("p23") double p23, @Param("p24") double p24, @Param("p25") double p25,
			@Param("p26") double p26, @Param("p27") double p27, @Param("p28") double p28, @Param("p29") double p29,
			@Param("p30") double p30, @Param("p31") double p31, @Param("p32") double p32, @Param("p33") double p33,
			@Param("p34") double p34, @Param("p35") double p35, @Param("p36") double p36, @Param("p37") double p37,
			@Param("p38") double p38, @Param("p39") double p39, @Param("p40") double p40, @Param("p41") double p41,
			@Param("p42") double p42, @Param("p43") double p43, @Param("p44") double p44, @Param("p45") double p45,
			@Param("p46") double p46, @Param("p47") double p47, @Param("p48") double p48, @Param("p49") double p49,
			@Param("p50") double p50, @Param("p51") double p51, @Param("p52") double p52, @Param("p53") double p53,
			@Param("p54") double p54, @Param("p55") double p55, @Param("p56") double p56, @Param("p57") double p57,
			@Param("p58") double p58, @Param("p59") double p59, @Param("p60") double p60, @Param("p61") double p61,
			@Param("p62") double p62, @Param("p63") double p63, @Param("p64") double p64, @Param("p65") double p65,
			@Param("p66") double p66, @Param("p67") double p67, @Param("p68") double p68, @Param("p69") double p69,
			@Param("p70") double p70, @Param("p71") double p71, @Param("p72") double p72, @Param("p73") double p73,
			@Param("p74") double p74, @Param("p75") double p75, @Param("p76") double p76, @Param("p77") double p77,
			@Param("p78") double p78, @Param("p79") double p79, @Param("p80") double p80, @Param("p81") double p81,
			@Param("p82") double p82, @Param("p83") double p83, @Param("p84") double p84, @Param("p85") double p85,
			@Param("p86") double p86, @Param("p87") double p87, @Param("p88") double p88, @Param("p89") double p89,
			@Param("p90") double p90, @Param("p91") double p91, @Param("p92") double p92, @Param("p93") double p93,
			@Param("p94") double p94, @Param("p95") double p95, @Param("p96") double p96, @Param("p97") double p97,
			@Param("p98") double p98, @Param("p99") double p99, @Param("p100") double p100, @Param("p101") double p101,
			@Param("p102") double p102, @Param("p103") double p103, @Param("p104") double p104,
			@Param("p105") double p105, @Param("p106") double p106, @Param("p107") double p107);
	
	@Query(value = "SELECT COUNT(1) FROM h_curvas WHERE Fh_Date=:fecha", nativeQuery = true)
	Integer existsByDate(@Param("fecha") String fecha);
	
	
}
