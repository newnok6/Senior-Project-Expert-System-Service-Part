//import drugExpertSystem.drugExpertSystem.Model.TabletFormulation;
//import drugExpertSystem.substance.Entity.SubstanceFunction.CompoundFunction;
//import drugExpertSystem.substance.Service.substanceFunctionService.CompoundFunctionServiceImpl;
//import drugExpertSystem.substance.Service.substancePropertyService.*;
//import drugExpertSystem.substance.repository.SolubilityRepository;

import static org.junit.Assert.assertEquals;

/**
 * Created by narongrit saisuwan on 7/4/2014.
 */
public class ServiceTest {
/*
    @Mock
    SolubilityServiceImpl solubilityService;
  SolidstateServiceImpl solidstateService;
    PkaServiceImpl pkaService;
    PartitionCoefficientServiceImpl partitionCoefficientService;
    ParticleSizeServiceImpl particleSizeService;
    KineticReactionServiceImpl kineticReactionService;
    HygroscopicityServiceImpl hygroscopicityService;
    FlowabilityServiceImpl flowabilityService;
    DensityServiceImpl    densityService;
    DegradationMechanismServiceImpl  degradationMechanismService;
    CompoundFunctionServiceImpl compoundFunctionService;
    @Before
    public void doSetup() {
        solubilityService = mock(SolubilityServiceImpl.class);
        solidstateService = mock(SolidstateServiceImpl.class);
        pkaService = mock(PkaServiceImpl.class);
        partitionCoefficientService =mock((PartitionCoefficientServiceImpl.class));
       particleSizeService = mock(ParticleSizeServiceImpl.class);
        kineticReactionService = mock(KineticReactionServiceImpl.class);
        hygroscopicityService = mock(HygroscopicityServiceImpl.class);
        flowabilityService = mock(FlowabilityServiceImpl.class);
        densityService = mock(DensityServiceImpl.class);
        degradationMechanismService = mock(DegradationMechanismServiceImpl.class);
        compoundFunctionService = mock(CompoundFunctionServiceImpl.class);

    }

    @Test

    public void testAddSolubility() throws Exception {

        //Test Data for demo//
        Solubility solubility1 = new Solubility("solubility1",4,2,5);
        Solubility solubility2 = new Solubility("solubility2",7,1,3);
        Solubility solubility3 = new Solubility("solubility3",4,4,2);
        Solubility solubility4 =  new Solubility("solubility4",6,3,6);


        Solubility solubility5 =  new Solubility(1,"solubility",4,2,5);
        Solubility solubility6 = new Solubility(2, "solubility1",7, 1, 3);

        //Condition for the test plan//
        when(solubilityService.add(any(Solubility.class))).thenReturn(null);
        when(solubilityService.add(solubility1)).thenReturn(solubility5);
        when(solubilityService.add(solubility2)).thenReturn(solubility6);

        //Case 1 and Case 2//
        assertEquals(solubility5, solubilityService.add(solubility1));
        assertEquals(solubility6,solubilityService.add(solubility2));

        //Case 3 and Case 4//
        assertNull(solubilityService.add(solubility3));
        assertNull(solubilityService.add(solubility4));
       // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdateSolubility() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)

        Solubility solubility = new Solubility(1,"solubility",4,2,5);
        Solubility solubility1 = new Solubility(2,"solubility1",7,3,10);
        Solubility solubility2 = new Solubility(1, "solubility5", 3, 1, 2);
        Solubility solubility3 = new Solubility(1,"solubility",4,2,5);
        Solubility solubility4 = new Solubility(3, "solubility2", 2, 1, 3);
        Solubility solubility5 = new Solubility(4,"solubility3",3,2,5);
        ArrayList<Solubility> solubilityArrayList = new ArrayList<Solubility>();
        solubilityArrayList.add(solubility);
        solubilityArrayList.add(solubility1);
        when(solubilityService.update(any(Solubility.class))).thenReturn(null);
        when(solubilityService.update(solubility )).thenReturn(solubility);
        when(solubilityService.update(solubility1)).thenReturn(solubility1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(solubility, solubilityService.update(solubility));
        assertEquals(solubility1,solubilityService.update(solubility1));
       // assertEquals(null,);

       assertNull(solubilityService.update(solubility2));
       assertNull(solubilityService.update(solubility3));
        assertNull(solubilityService.update(solubility4));
        assertNull(solubilityService.update(solubility5));



    }

    @Test
    public void testdeleteSolubility() throws Exception {
        Solubility solubility = new Solubility(1,"solubility",4,2,5);
        Solubility solubility1 = new Solubility(2,"solubility",7,3,10);
        when(solubilityService.delete(any(Solubility.class))).thenReturn(null);
        when(solubilityService.delete(solubility)).thenReturn(solubility);
        when(solubilityService.delete(solubility1)).thenReturn(solubility1);
        assertEquals(solubility,solubilityService.delete(solubility));
        assertEquals(solubility1,solubilityService.delete(solubility1));
        assertNull(solubilityService.delete(new Solubility(3, "solubility", 4, 1, 3)));


    }

    @Test

    public void testgetSolubilityByID() throws Exception {
        Solubility solubility = new Solubility(1,"solubility",4,2,5);
        Solubility solubility1 = new Solubility(2,"solubility1",7,3,10);
        when(solubilityService.getByID(anyInt())).thenReturn(null);
        when(solubilityService.getByID(1)).thenReturn(solubility);
        when(solubilityService.getByID(2)).thenReturn(solubility1);
        assertEquals(solubility,solubilityService.getByID(1));
        assertEquals(solubility1,solubilityService.getByID(2));

        assertNull(solubilityService.getByID(4));

    }
    @Test


    public  void testgetSolubilityByType() throws Exception {
        Solubility solubility = new Solubility(1,"solubility",4,2,5);
        Solubility solubility1 = new Solubility(2,"solubility1",7,3,10);
        when(solubilityService.getByType(anyString())).thenReturn(null);
        when(solubilityService.getByType("solubility")).thenReturn(solubility);
        when(solubilityService.getByType("solubility1")).thenReturn(solubility1);
        assertEquals(solubility, solubilityService.getByType("solubility"));
        assertEquals(solubility1,solubilityService.getByType("solubility1"));
        assertNull(solubilityService.getByType("solubilitty2"));
    }

    @Test

    public  void testgetAllSolubility() throws Exception {
        Solubility solubility = new Solubility(1,"solubility",4,2,5);
        Solubility solubility1 = new Solubility(2,"solubility1",7,3,10);
        List<Solubility> solubilities = new ArrayList<Solubility>();
        solubilities.add(solubility);
        solubilities.add(solubility1);
        when(solubilityService.getAll()).thenReturn(solubilities);
        assertEquals(solubilities, solubilityService.getAll());
        assertEquals(2,solubilityService.getAll().size());

    }



/*

    @Test

    public void testAddSolidstate() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
       Solidstate solidstate = new Solidstate("solidstate");
        Solidstate solidstate1 = new Solidstate("solidstate1");
        Solidstate solidstate2 = new Solidstate("solidstate");
        Solidstate solidstate3 = new Solidstate("solidstate1");

        Solidstate solidstate4 = new Solidstate(1,"solidstate");
        Solidstate solidstate5 = new Solidstate(2,"solidstate1");


        when(solidstateService.add(any(Solidstate.class))).thenReturn(null);
        when(solidstateService.add(solidstate)).thenReturn(solidstate4);
        when(solidstateService.add(solidstate1)).thenReturn(solidstate5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(solidstate4, solidstateService.add(solidstate));
        assertEquals(solidstate5,solidstateService.add(solidstate1));

        assertNull(solidstateService.add(solidstate2));
        assertNull(solidstateService.add(solidstate3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdateSolidstate() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)
              Solidstate solidstate = new Solidstate(1,"solidstateTest1");
        Solidstate solidstate1 = new Solidstate(2,"solidstateTest2");
        Solidstate solidstate2 = new Solidstate(1,"solidstateTest3");
        Solidstate solidstate3 = new Solidstate(1,"solidstateTest1");
        Solidstate solidstate4 = new Solidstate(3,"solidstateTest1");
        Solidstate solidstate5 = new Solidstate(4,"solidstateTest1");


        when(solubilityService.update(any(Solubility.class))).thenReturn(null);
        when(solidstateService.update(solidstate )).thenReturn(solidstate);
        when(solidstateService.update(solidstate1)).thenReturn(solidstate1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(solidstate, solidstateService.update(solidstate));
        assertEquals(solidstate1,solidstateService.update(solidstate1));
        // assertEquals(null,);

        assertNull(solidstateService.update(solidstate2));
        assertNull(solidstateService.update(solidstate3));
        assertNull(solidstateService.update(solidstate4));
        assertNull(solidstateService.update(solidstate5));



    }

    @Test
    public void testdeleteSolidstate() throws Exception {
        Solidstate solidstate = new Solidstate(1,"solidstateTest1");
        Solidstate solidstate1 = new Solidstate(2,"solidstateTest2");
        when(solidstateService.delete(any(Solidstate.class))).thenReturn(null);
        when(solidstateService.delete(solidstate)).thenReturn(solidstate);
        when(solidstateService.delete(solidstate1)).thenReturn(solidstate1);
        assertEquals(solidstate,solidstateService.delete(solidstate));
        assertEquals(solidstate1,solidstateService.delete(solidstate1));
        assertNull(solidstateService.delete(new Solidstate(3, "solodstate")));


    }

    @Test

    public void testgetSolidstateByID() throws Exception {
        Solidstate solidstate = new Solidstate(1,"solidstateTest1");
        Solidstate solidstate1 = new Solidstate(2,"solidstateTest2");
        when(solidstateService.getByID(anyInt())).thenReturn(null);
        when(solidstateService.getByID(1)).thenReturn(solidstate);
        when(solidstateService.getByID(2)).thenReturn(solidstate1);
        assertEquals(solidstate,solidstateService.getByID(1));
        assertEquals(solidstate1,solidstateService.getByID(2));

        assertNull(solidstateService.getByID(4));

    }
    @Test

    public  void testgetSolidstateByType() throws Exception {
        Solidstate solidstate = new Solidstate(1,"solidstateTest1");
        Solidstate solidstate1 = new Solidstate(2,"solidstateTest2");
        when(solidstateService.getByType(anyString())).thenReturn(null);
        when(solidstateService.getByType("solubility")).thenReturn(solidstate);
        when(solidstateService.getByType("solubility1")).thenReturn(solidstate1);
        assertEquals(solidstate, solidstateService.getByType("solubility"));
        assertEquals(solidstate1,solidstateService.getByType("solubility1"));
        assertNull(solidstateService.getByType("solubilitty2"));
    }

    @Test

    public  void testgetAllSolidstate() throws Exception {
        Solidstate solidstate = new Solidstate(1,"solidstateTest1");
        Solidstate solidstate1 = new Solidstate(2,"solidstateTest2");
        List<Solidstate> solidstates = new ArrayList<Solidstate>();
        solidstates.add(solidstate);
       solidstates.add(solidstate1);
        when(solidstateService.getAll()).thenReturn(solidstates);
        assertEquals(solidstates, solidstateService.getAll());
        assertEquals(2,solidstateService.getAll().size());

    }


    @Test

    public void testAddPka() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
        Pka pka = new Pka("pka",4,2,2);
        Pka pka1 = new Pka("pka1",6,3,6);
        Pka pka2 = new Pka("pka",9,3,6);
        Pka pka3 =  new Pka("pka1",3,1,9);

        Pka pka4 =  new Pka(1,"pka",4,2,2);
        Pka pka5 = new Pka(2, "pka1", 6, 3, 6);
        when(pkaService.add(any(Pka.class))).thenReturn(null);
        when(pkaService.add(pka)).thenReturn(pka4);
        when(pkaService.add(pka1)).thenReturn(pka5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(pka4, pkaService.add(pka));
        assertEquals(pka5,pkaService.add(pka1));

        assertNull(pkaService.add(pka2));
        assertNull(pkaService.add(pka3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdatePka() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)

        Pka pka = new Pka(1,"pka",4,2,5);
        Pka pka1 = new Pka(2,"pka1",7,3,10);
        Pka pka2 = new Pka(1, "pka5", 3, 1, 2);
        Pka pka3 = new Pka(1,"pka",4,2,5);
        Pka pka4 = new Pka(3, "pka2", 2, 1, 3);
        Pka pka5 = new Pka(4,"pka3",3,2,5);

        when(pkaService.update(any(Pka.class))).thenReturn(null);
        when(pkaService.update(pka )).thenReturn(pka);
        when(pkaService.update(pka1)).thenReturn(pka1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(pka, pkaService.update(pka));
        assertEquals(pka1,pkaService.update(pka1));
        // assertEquals(null,);

        assertNull(pkaService.update(pka2));
        assertNull(pkaService.update(pka3));
        assertNull(pkaService.update(pka4));
        assertNull(pkaService.update(pka5));



    }

    @Test
    public void testdeletePka() throws Exception {
        Pka pka = new Pka(1,"pka",4,2,5);
        Pka pka1 = new Pka(2,"pka1",7,3,10);
        when(pkaService.delete(any(Pka.class))).thenReturn(null);
        when(pkaService.delete(pka)).thenReturn(pka);
        when(pkaService.delete(pka1)).thenReturn(pka1);
        assertEquals(pka,pkaService.delete(pka));
        assertEquals(pka1,pkaService.delete(pka1));
        assertNull(pkaService.delete(new Pka(3, "pak3", 4, 1, 3)));


    }

    @Test

    public void testgetPkaByID() throws Exception {
        Solubility solubility = new Solubility(1,"solubility",4,2,5);
        Solubility solubility1 = new Solubility(2,"solubility1",7,3,10);
        when(solubilityService.getByID(anyInt())).thenReturn(null);
        when(solubilityService.getByID(1)).thenReturn(solubility);
        when(solubilityService.getByID(2)).thenReturn(solubility1);
        assertEquals(solubility,solubilityService.getByID(1));
        assertEquals(solubility1,solubilityService.getByID(2));

        assertNull(solubilityService.getByID(4));

    }
    @Test

    public  void testgetPkaByType() throws Exception {
       Pka pka = new Pka(1,"pka",4,2,5);
        Pka pka1 = new Pka(2,"pka1",7,3,10);
        when(pkaService.getByType(anyString())).thenReturn(null);
        when(pkaService.getByType("pka")).thenReturn(pka);
        when(pkaService.getByType("pka1")).thenReturn(pka1);
        assertEquals(pka, pkaService.getByType("pka"));
        assertEquals(pka1,pkaService.getByType("pka1"));
        assertNull(pkaService.getByType("pka2"));
    }

    @Test

    public  void testgetAllPka() throws Exception {
        Pka pka = new Pka(1,"pka",4,2,5);
        Pka pka1 = new Pka(2,"pka1",7,3,10);
        List<Pka> pkas = new ArrayList<Pka>();
        pkas.add(pka);
        pkas.add(pka1);
        when(pkaService.getAll()).thenReturn(pkas);
        assertEquals(pkas, pkaService.getAll());
        assertEquals(2,pkaService.getAll().size());

    }

    @Test

    public void testAddPartitionCoefficient() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
        PartitionCoefficient partitionCoefficient = new PartitionCoefficient("PartitionCoefficient",2);
        PartitionCoefficient partitionCoefficient1 = new PartitionCoefficient("PartitionCoefficient1",6);
        PartitionCoefficient partitionCoefficient2 = new PartitionCoefficient("PartitionCoefficient",6);
        PartitionCoefficient partitionCoefficient3 =  new PartitionCoefficient("PartitionCoefficient1",9);

        PartitionCoefficient partitionCoefficient4 =  new PartitionCoefficient(1,"PartitionCoefficient",2);
        PartitionCoefficient partitionCoefficient5 = new PartitionCoefficient(2, "PartitionCoefficient1", 6);
        when(partitionCoefficientService.add(any(PartitionCoefficient.class))).thenReturn(null);
        when(partitionCoefficientService.add(partitionCoefficient)).thenReturn(partitionCoefficient4);
        when(partitionCoefficientService.add(partitionCoefficient1)).thenReturn(partitionCoefficient5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(partitionCoefficient4, partitionCoefficientService.add(partitionCoefficient));
        assertEquals(partitionCoefficient5,partitionCoefficientService.add(partitionCoefficient1));

        assertNull(partitionCoefficientService.add(partitionCoefficient2));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdatePartitionCoefficient() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)

        PartitionCoefficient partitionCoefficient = new PartitionCoefficient(1,"partitionCoefficient",5);
        PartitionCoefficient partitionCoefficient1 = new PartitionCoefficient(2,"partitionCoefficient1",10);
        PartitionCoefficient partitionCoefficient2 = new PartitionCoefficient (1, "partitionCoefficient5",  2);
        PartitionCoefficient partitionCoefficient3 = new PartitionCoefficient(1,"partitionCoefficient",5);
        PartitionCoefficient partitionCoefficient4= new PartitionCoefficient(3, "partitionCoefficient2",  3);
        PartitionCoefficient partitionCoefficient5 = new PartitionCoefficient(4,"partitionCoefficient3",5);

        when(partitionCoefficientService.update(any(PartitionCoefficient.class))).thenReturn(null);
        when(partitionCoefficientService.update(partitionCoefficient )).thenReturn(partitionCoefficient);
        when(partitionCoefficientService.update(partitionCoefficient1)).thenReturn(partitionCoefficient1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(partitionCoefficient, partitionCoefficientService.update(partitionCoefficient));
        assertEquals(partitionCoefficient1,partitionCoefficientService.update(partitionCoefficient1));
        // assertEquals(null,);

        assertNull(partitionCoefficientService.update(partitionCoefficient2));
        assertNull(partitionCoefficientService.update(partitionCoefficient3));
        assertNull(partitionCoefficientService.update(partitionCoefficient4));
        assertNull(partitionCoefficientService.update(partitionCoefficient5));



    }

    @Test
    public void testdeletePartitionCoefficient() throws Exception {
        PartitionCoefficient partitionCoefficient = new PartitionCoefficient(1,"partitionCoefficient",5);
        PartitionCoefficient partitionCoefficient1 = new PartitionCoefficient(2,"partitionCoefficient1",10);
        when(partitionCoefficientService.delete(any(PartitionCoefficient.class))).thenReturn(null);
        when(partitionCoefficientService.delete(partitionCoefficient)).thenReturn(partitionCoefficient);
        when(partitionCoefficientService.delete(partitionCoefficient1)).thenReturn(partitionCoefficient1);
        assertEquals(partitionCoefficient,partitionCoefficientService.delete(partitionCoefficient));
        assertEquals(partitionCoefficient1,partitionCoefficientService.delete(partitionCoefficient1));
        assertNull(partitionCoefficientService.delete(new PartitionCoefficient(3, "partitionCoefficient3", 3)));


    }

    @Test

    public void testgetPartitionCoefficientByID() throws Exception {
        PartitionCoefficient partitionCoefficient = new PartitionCoefficient(1,"partitionCoefficient",5);
        PartitionCoefficient partitionCoefficient1 = new PartitionCoefficient(2,"partitionCoefficient1",10);

        when(partitionCoefficientService.getByID(anyInt())).thenReturn(null);
        when(partitionCoefficientService.getByID(1)).thenReturn(partitionCoefficient);
        when(partitionCoefficientService.getByID(2)).thenReturn(partitionCoefficient1);
        assertEquals(partitionCoefficient,partitionCoefficientService.getByID(1));
        assertEquals(partitionCoefficient1,partitionCoefficientService.getByID(2));

        assertNull(solubilityService.getByID(4));

    }
    @Test

    public  void testgetPartitionCoefficientByType() throws Exception {
        PartitionCoefficient partitionCoefficient = new PartitionCoefficient(1,"partitionCoefficient",5);
        PartitionCoefficient partitionCoefficient1 = new PartitionCoefficient(2,"partitionCoefficient1",10);
        when(partitionCoefficientService.getByType(anyString())).thenReturn(null);
        when(partitionCoefficientService.getByType("partitionCoefficient")).thenReturn(partitionCoefficient);
        when(partitionCoefficientService.getByType("partitionCoefficient1")).thenReturn(partitionCoefficient1);
        assertEquals(partitionCoefficient, partitionCoefficientService.getByType("partitionCoefficient"));
        assertEquals(partitionCoefficient1,partitionCoefficientService.getByType("partitionCoefficient1"));
        assertNull(partitionCoefficientService.getByType("partitionCoefficient2"));
    }

    @Test

    public  void tesPartitionCoefficienttgetAll() throws Exception {
        PartitionCoefficient partitionCoefficient = new PartitionCoefficient(1,"partitionCoefficient",5);
        PartitionCoefficient partitionCoefficient1 = new PartitionCoefficient(2,"partitionCoefficient1",10);
        List<PartitionCoefficient> partitionCoefficients = new ArrayList<PartitionCoefficient>();
        partitionCoefficients.add(partitionCoefficient);
        partitionCoefficients.add(partitionCoefficient1);
        when(partitionCoefficientService.getAll()).thenReturn(partitionCoefficients);
        assertEquals(partitionCoefficients, partitionCoefficientService.getAll());
        assertEquals(2,partitionCoefficientService.getAll().size());

    }


    @Test

    public void testAddParticleSize() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
        ParticleSize particleSize = new ParticleSize("ParticleSize",4,2,2);
        ParticleSize particleSize1 = new ParticleSize("ParticleSize1",6,3,6);
        ParticleSize particleSize2 = new ParticleSize("ParticleSize",9,3,6);
        ParticleSize particleSize3 = new ParticleSize("ParticleSize1",3,1,9);

        ParticleSize particleSize4 = new ParticleSize(1,"solubility",4,2,2);
        ParticleSize particleSize5 = new ParticleSize(2, "solubility1", 6, 3, 6);
        when(particleSizeService.add(any(ParticleSize.class))).thenReturn(null);
        when(particleSizeService.add(particleSize)).thenReturn(particleSize4);
        when(particleSizeService.add(particleSize1)).thenReturn(particleSize5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(particleSize4, particleSizeService.add(particleSize));
        assertEquals(particleSize5,particleSizeService.add(particleSize1));

        assertNull(particleSizeService.add(particleSize2));
        assertNull(particleSizeService.add(particleSize3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdateParticleSize() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)

        ParticleSize particleSize = new ParticleSize(1,"particleSize",4,2,5);
        ParticleSize particleSize1 = new ParticleSize(2,"particleSize1",7,3,10);
        ParticleSize particleSize2 = new ParticleSize(1, "particleSize5", 3, 1, 2);
        ParticleSize particleSize3 = new ParticleSize (1,"particleSize",4,2,5);
        ParticleSize particleSize4 = new ParticleSize(3, "particleSize2", 2, 1, 3);
        ParticleSize particleSize5 = new ParticleSize(4,"particleSize3",3,2,5);

        when(particleSizeService.update(any(ParticleSize.class))).thenReturn(null);
        when(particleSizeService.update(particleSize )).thenReturn(particleSize);
        when(particleSizeService.update(particleSize1)).thenReturn(particleSize1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(particleSize, particleSizeService.update(particleSize));
        assertEquals(particleSize1,particleSizeService.update(particleSize1));
        // assertEquals(null,);

        assertNull(particleSizeService.update(particleSize2));
        assertNull(particleSizeService.update(particleSize3));
        assertNull(particleSizeService.update(particleSize4));
        assertNull(particleSizeService.update(particleSize5));



    }

    @Test
    public void testdeleteParticleSize() throws Exception {
        ParticleSize particleSize = new ParticleSize(1,"particleSize",4,2,5);
        ParticleSize particleSize1 = new ParticleSize(2,"particleSize1",7,3,10);
        when(particleSizeService.delete(any(ParticleSize.class))).thenReturn(null);
        when(particleSizeService.delete(particleSize)).thenReturn(particleSize);
        when(particleSizeService.delete(particleSize1)).thenReturn(particleSize1);
        assertEquals(particleSize,particleSizeService.delete(particleSize));
        assertEquals(particleSize1,particleSizeService.delete(particleSize1));
        assertNull(particleSizeService.delete(new ParticleSize(3, "solubility", 4, 1, 3)));


    }

    @Test

    public void testgetParticleSizeByID() throws Exception {
        ParticleSize particleSize = new ParticleSize(1,"particleSize",4,2,5);
        ParticleSize particleSize1 = new ParticleSize(2,"particleSize1",7,3,10);
        when(particleSizeService.getByID(anyInt())).thenReturn(null);
        when(particleSizeService.getByID(1)).thenReturn(particleSize);
        when(particleSizeService.getByID(2)).thenReturn(particleSize1);
        assertEquals(particleSize,particleSizeService.getByID(1));
        assertEquals(particleSize1,particleSizeService.getByID(2));

        assertNull(particleSizeService.getByID(4));

    }
    @Test

    public  void testgetParticleSizeByType() throws Exception {
        ParticleSize particleSize = new ParticleSize(1,"particleSize",4,2,5);
        ParticleSize particleSize1 = new ParticleSize(2,"particleSize1",7,3,10);
        when(particleSizeService.getByType(anyString())).thenReturn(null);
        when(particleSizeService.getByType("particleSize")).thenReturn(particleSize);
        when(particleSizeService.getByType("particleSize1")).thenReturn(particleSize1);
        assertEquals(particleSize, particleSizeService.getByType("particleSize"));
        assertEquals(particleSize1,particleSizeService.getByType("particleSize1"));
        assertNull(particleSizeService.getByType("particleSize2"));
    }

    @Test

    public  void testgetAllParticleSize() throws Exception {
        ParticleSize particleSize = new ParticleSize(1,"particleSize",4,2,5);
        ParticleSize particleSize1 = new ParticleSize(2,"particleSize1",7,3,10);
        List<ParticleSize> particleSizes = new ArrayList<ParticleSize>();
        particleSizes.add(particleSize);
        particleSizes.add(particleSize1);
        when(particleSizeService.getAll()).thenReturn(particleSizes);
        assertEquals(particleSizes, particleSizeService.getAll());
        assertEquals(2,particleSizeService.getAll().size());

    }




    @Test

    public void testAddKineticReaction() throws Exception {


        KineticReaction  kineticReaction = new KineticReaction("kineticReaction");
        KineticReaction  kineticReaction1 = new KineticReaction ("kineticReaction1");
        KineticReaction  kineticReaction2 = new KineticReaction("kineticReaction");
        KineticReaction  kineticReaction3 = new KineticReaction("kineticReaction1");

        KineticReaction  kineticReaction4 = new KineticReaction(1,"kineticReaction");
        KineticReaction  kineticReaction5 = new KineticReaction(2,"kineticReaction1");


        when(kineticReactionService.add(any(KineticReaction.class))).thenReturn(null);
        when(kineticReactionService.add(kineticReaction)).thenReturn(kineticReaction4);
        when(kineticReactionService.add(kineticReaction1)).thenReturn(kineticReaction5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(kineticReaction4, kineticReactionService.add(kineticReaction));
        assertEquals(kineticReaction5,kineticReactionService.add(kineticReaction1));

        assertNull(kineticReactionService.add(kineticReaction2));
        assertNull(kineticReactionService.add(kineticReaction3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdatekineticReaction() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)
        KineticReaction  kineticReaction = new KineticReaction (1,"kineticReactionTest1");
        KineticReaction  kineticReaction1 = new KineticReaction (2,"kineticReactionTest2");
        KineticReaction  kineticReaction2 = new KineticReaction (1,"kineticReactionTest3");
        KineticReaction  kineticReaction3 = new KineticReaction (1,"kineticReactionTest1");
        KineticReaction  kineticReaction4 = new KineticReaction (3,"kineticReactionTest1");
        KineticReaction  kineticReaction5 = new KineticReaction (3,"kineticReactionTest1");


        when(kineticReactionService.update(any(KineticReaction.class))).thenReturn(null);
        when(kineticReactionService.update(kineticReaction )).thenReturn(kineticReaction);
        when(kineticReactionService.update(kineticReaction1)).thenReturn(kineticReaction1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(kineticReaction, kineticReactionService.update(kineticReaction));
        assertEquals(kineticReaction1,kineticReactionService.update(kineticReaction1));
        // assertEquals(null,);

        assertNull(kineticReactionService.update(kineticReaction2));
        assertNull(kineticReactionService.update(kineticReaction3));
        assertNull(kineticReactionService.update(kineticReaction4));
        assertNull(kineticReactionService.update(kineticReaction5));



    }

    @Test
    public void testdeleteKineticReaction() throws Exception {
        KineticReaction  kineticReaction = new KineticReaction (1,"kineticReactionTest1");
        KineticReaction  kineticReaction1 = new KineticReaction (2,"kineticReactionTest2");
        when(kineticReactionService.delete(any(KineticReaction.class))).thenReturn(null);
        when(kineticReactionService.delete(kineticReaction)).thenReturn(kineticReaction);
        when(kineticReactionService.delete(kineticReaction1)).thenReturn(kineticReaction1);
        assertEquals(kineticReaction,kineticReactionService.delete(kineticReaction));
        assertEquals(kineticReaction1,kineticReactionService.delete(kineticReaction1));
        assertNull(kineticReactionService.delete(new KineticReaction(3, "kineticReaction")));


    }

    @Test

    public void testgetKineticReactionByID() throws Exception {
        KineticReaction  kineticReaction = new KineticReaction (1,"kineticReactionTest1");
        KineticReaction  kineticReaction1 = new KineticReaction (2,"kineticReactionTest2");
        when(kineticReactionService.getByID(anyInt())).thenReturn(null);
        when(kineticReactionService.getByID(1)).thenReturn(kineticReaction);
        when(kineticReactionService.getByID(2)).thenReturn(kineticReaction1);
        assertEquals(kineticReaction,kineticReactionService.getByID(1));
        assertEquals(kineticReaction1,kineticReactionService.getByID(2));

        assertNull(kineticReactionService.getByID(4));

    }
    @Test

    public  void testgetKineticReactionByType() throws Exception {
        KineticReaction  kineticReaction = new KineticReaction (1,"kineticReactionTest1");
        KineticReaction  kineticReaction1 = new KineticReaction (2,"kineticReactionTest2");
        when(kineticReactionService.getByType(anyString())).thenReturn(null);
        when(kineticReactionService.getByType("kineticReactionTest1")).thenReturn(kineticReaction);
        when(kineticReactionService.getByType("kineticReactionTest2")).thenReturn(kineticReaction1);
        assertEquals(kineticReaction, kineticReactionService.getByType("kineticReactionTest1"));
        assertEquals(kineticReaction1,kineticReactionService.getByType("kineticReactionTest2"));
        assertNull(kineticReactionService.getByType("kineticReactionTest3"));
    }

    @Test

    public  void testgetAllKineticReaction() throws Exception {
        KineticReaction  kineticReaction = new KineticReaction (1,"kineticReactionTest1");
        KineticReaction  kineticReaction1 = new KineticReaction (2,"kineticReactionTest2");
        List<KineticReaction>  kineticReactions= new ArrayList<KineticReaction>();
        kineticReactions.add(kineticReaction);
        kineticReactions.add(kineticReaction1);
        when(kineticReactionService.getAll()).thenReturn(kineticReactions);
        assertEquals(kineticReactions, kineticReactionService.getAll());
        assertEquals(2,kineticReactionService.getAll().size());

    }



    @Test

    public void testAddHygroscopicity() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
            Hygroscopicity hygroscopicity = new Hygroscopicity("hygroscopicity",4,2,"weight");
        Hygroscopicity hygroscopicity1 = new Hygroscopicity("hygroscopicity1",6,3,"weight1");
        Hygroscopicity hygroscopicity2 = new Hygroscopicity("hygroscopicity",9,3,"weight2");
        Hygroscopicity hygroscopicity3 = new Hygroscopicity("hygroscopicity1",3,1,"weight3");

        Hygroscopicity hygroscopicity4 = new Hygroscopicity(1,"hygroscopicity",4,2,"weight");
        Hygroscopicity hygroscopicity5 = new Hygroscopicity(2, "hygroscopicity1", 6, 3,"weight1");
        when(hygroscopicityService.add(any(Hygroscopicity.class))).thenReturn(null);
        when(hygroscopicityService.add(hygroscopicity)).thenReturn(hygroscopicity4);
        when(hygroscopicityService.add(hygroscopicity1)).thenReturn(hygroscopicity5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(hygroscopicity4, hygroscopicityService.add(hygroscopicity));
        assertEquals(hygroscopicity5,hygroscopicityService.add(hygroscopicity1));

        assertNull(hygroscopicityService.add(hygroscopicity2));
        assertNull(hygroscopicityService.add(hygroscopicity3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdateHygroscopicity() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)

        Hygroscopicity hygroscopicity = new Hygroscopicity (1,"hygroscopicity",4,2,"weightTest");
        Hygroscopicity hygroscopicity1 = new Hygroscopicity(2,"hygroscopicity1",7,3,"weightTest1");
        Hygroscopicity hygroscopicity2 = new Hygroscopicity(1, "hygroscopicity5", 3, 1, "weight2");
        Hygroscopicity hygroscopicity3 = new Hygroscopicity(1,"hygroscopicity",4,2,"weight3");
        Hygroscopicity hygroscopicity4 = new Hygroscopicity(3, "hygroscopicity2", 2, 1, "weight4");
        Hygroscopicity hygroscopicity5 = new Hygroscopicity(4,"hygroscopicity3",3,2,"weight5");

        when(hygroscopicityService.update(any(Hygroscopicity.class))).thenReturn(null);
        when(hygroscopicityService.update(hygroscopicity )).thenReturn(hygroscopicity);
        when(hygroscopicityService.update(hygroscopicity1)).thenReturn(hygroscopicity1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(hygroscopicity, hygroscopicityService.update(hygroscopicity));
        assertEquals(hygroscopicity1,hygroscopicityService.update(hygroscopicity1));
        // assertEquals(null,);

        assertNull(hygroscopicityService.update(hygroscopicity2));
        assertNull(hygroscopicityService.update(hygroscopicity3));
        assertNull(hygroscopicityService.update(hygroscopicity4));
        assertNull(hygroscopicityService.update(hygroscopicity5));



    }

    @Test
    public void testdeleteHygroscopicity() throws Exception {
        Hygroscopicity hygroscopicity = new Hygroscopicity (1,"hygroscopicity",4,2,"weightTest");
        Hygroscopicity hygroscopicity1 = new Hygroscopicity(2,"hygroscopicity1",7,3,"weightTest1");
        when(hygroscopicityService.delete(any(Hygroscopicity.class))).thenReturn(null);
        when(hygroscopicityService.delete(hygroscopicity)).thenReturn(hygroscopicity);
        when(hygroscopicityService.delete(hygroscopicity1)).thenReturn(hygroscopicity1);
        assertEquals(hygroscopicity,hygroscopicityService.delete(hygroscopicity));
        assertEquals(hygroscopicity1,hygroscopicityService.delete(hygroscopicity1));
        assertNull(hygroscopicityService.delete(new Hygroscopicity(3, "solubility", 4, 1, "weigh2")));


    }

    @Test

    public void testgetHygroscopicityByID() throws Exception {
        Hygroscopicity hygroscopicity = new Hygroscopicity (1,"hygroscopicity",4,2,"weightTest");
        Hygroscopicity hygroscopicity1 = new Hygroscopicity(2,"hygroscopicity1",7,3,"weightTest1");
        when(hygroscopicityService.getByID(anyInt())).thenReturn(null);
        when(hygroscopicityService.getByID(1)).thenReturn(hygroscopicity);
        when(hygroscopicityService.getByID(2)).thenReturn(hygroscopicity1);
        assertEquals(hygroscopicity,hygroscopicityService.getByID(1));
        assertEquals(hygroscopicity1,hygroscopicityService.getByID(2));

        assertNull(hygroscopicityService.getByID(4));

    }
    @Test

    public  void testgetHygroscopicityByType() throws Exception {
        Hygroscopicity hygroscopicity = new Hygroscopicity (1,"hygroscopicity",4,2,"weightTest");
        Hygroscopicity hygroscopicity1 = new Hygroscopicity(2,"hygroscopicity1",7,3,"weightTest1");
        when(hygroscopicityService.getByType(anyString())).thenReturn(null);
        when(hygroscopicityService.getByType("hygroscopicity")).thenReturn(hygroscopicity);
        when(hygroscopicityService.getByType("hygroscopicity1")).thenReturn(hygroscopicity1);
        assertEquals(hygroscopicity, hygroscopicityService.getByType("hygroscopicity"));
        assertEquals(hygroscopicity1,hygroscopicityService.getByType("hygroscopicity1"));
        assertNull(hygroscopicityService.getByType("hygroscopicity2"));
    }

    @Test

    public  void testgetAllHygroscopicity() throws Exception {
        Hygroscopicity hygroscopicity = new Hygroscopicity (1,"hygroscopicity",4,2,"weightTest");
        Hygroscopicity hygroscopicity1 = new Hygroscopicity(2,"hygroscopicity1",7,3,"weightTest1");
        List<Hygroscopicity>  hygroscopicities= new ArrayList<Hygroscopicity>();
        hygroscopicities.add(hygroscopicity);
        hygroscopicities.add(hygroscopicity1);
        when(hygroscopicityService.getAll()).thenReturn(hygroscopicities);
        assertEquals(hygroscopicities, hygroscopicityService.getAll());
        assertEquals(2,hygroscopicityService.getAll().size());

    }


    @Test

    public void testAddFlowability() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
        Flowability  flowability = new Flowability("flowability");
        Flowability  flowability1 = new Flowability("flowability1");
        Flowability  flowability2 = new Flowability("flowability");
        Flowability  flowability3 = new Flowability("flowability1");

        Flowability  flowability4 = new Flowability(1,"flowability");
        Flowability  flowability5 = new Flowability(2,"flowability1");


        when(flowabilityService.add(any(Flowability.class))).thenReturn(null);
        when(flowabilityService.add(flowability)).thenReturn(flowability4);
        when(flowabilityService.add(flowability1)).thenReturn(flowability5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(flowability4, flowabilityService.add(flowability));
        assertEquals(flowability5,flowabilityService.add(flowability1));

        assertNull(flowabilityService.add(flowability2));
        assertNull(flowabilityService.add(flowability3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdateFlowability() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)
        Flowability  flowability = new Flowability(1,"flowabilityTest1");
        Flowability  flowability1 = new Flowability (2,"flowabilityTest2");
        Flowability  flowability2 = new Flowability(1,"flowabilityTest3");
        Flowability  flowability3 = new Flowability(1,"flowabilityTest1");
        Flowability  flowability4 = new Flowability(3,"flowabilityTest1");
        Flowability  flowability5 = new Flowability(4,"flowabilityTest1");


        when(flowabilityService.update(any(Flowability.class))).thenReturn(null);
        when(flowabilityService.update(flowability )).thenReturn(flowability);
        when(flowabilityService.update(flowability1)).thenReturn(flowability1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(flowability, flowabilityService.update(flowability));
        assertEquals(flowability1,flowabilityService.update(flowability1));
        // assertEquals(null,);

        assertNull(flowabilityService.update(flowability2));
        assertNull(flowabilityService.update(flowability3));
        assertNull(flowabilityService.update(flowability4));
        assertNull(flowabilityService.update(flowability5));



    }

    @Test
    public void testdeleteFlowability() throws Exception {
        Flowability  flowability = new Flowability (1,"flowabilityTest1");
        Flowability  flowability1 = new Flowability (2,"flowabilityTest2");
        when(flowabilityService.delete(any(Flowability.class))).thenReturn(null);
        when(flowabilityService.delete(flowability)).thenReturn(flowability);
        when(flowabilityService.delete(flowability1)).thenReturn(flowability1);
        assertEquals(flowability,flowabilityService.delete(flowability));
        assertEquals(flowability1,flowabilityService.delete(flowability1));
        assertNull(flowabilityService.delete(new Flowability(3, "flowabilityTest")));


    }

    @Test

    public void testgetFlowabilityByID() throws Exception {
        Flowability  flowability = new Flowability (1,"flowabilityTest1");
        Flowability  flowability1 = new Flowability (2,"flowabilityTest2");
        when(flowabilityService.getByID(anyInt())).thenReturn(null);
        when(flowabilityService.getByID(1)).thenReturn(flowability);
        when(flowabilityService.getByID(2)).thenReturn(flowability1);
        assertEquals(flowability,flowabilityService.getByID(1));
        assertEquals(flowability1,flowabilityService.getByID(2));

        assertNull(flowabilityService.getByID(4));

    }
    @Test

    public  void testgetFlowabilityByType() throws Exception {
        Flowability  flowability = new Flowability (1,"flowabilityTest1");
        Flowability  flowability1 = new Flowability (2,"flowabilityTest2");
        when(flowabilityService.getByType(anyString())).thenReturn(null);
        when(flowabilityService.getByType("flowabilityTest1")).thenReturn(flowability);
        when(flowabilityService.getByType("flowabilityTest2")).thenReturn(flowability1);
        assertEquals(flowability, flowabilityService.getByType("flowabilityTest1"));
        assertEquals(flowability1,flowabilityService.getByType("flowabilityTest2"));
        assertNull(flowabilityService.getByType("flowabilityTest3"));
    }

    @Test

    public  void testgetAllFlowability() throws Exception {
        Flowability  flowability = new Flowability (1,"flowabilityTest1");
        Flowability  flowability1 = new Flowability (2,"flowabilityTest2");
        List<Flowability>  flowabilities= new ArrayList<Flowability>();
        flowabilities.add(flowability);
        flowabilities.add(flowability1);
        when(flowabilityService.getAll()).thenReturn(flowabilities);
        assertEquals(flowabilities, flowabilityService.getAll());
        assertEquals(2,flowabilityService.getAll().size());

    }

    @Test

    public void testAddDensity() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
        Density density= new Density("density",2);
        Density density1= new Density("density1",6);
        Density density2= new Density("density",6);
        Density density3= new Density("density1",9);

        Density density4= new Density(1,"density",2);
        Density density5= new Density(2, "density1", 6);
        when(densityService.add(any(Density.class))).thenReturn(null);
        when(densityService.add(density)).thenReturn(density4);
        when(densityService.add(density1)).thenReturn(density5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(density4, densityService.add(density));
        assertEquals(density5,densityService.add(density1));

        assertNull(densityService.add(density2));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdateDensity() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)

        Density density= new Density(1,"density",5);
        Density density1= new Density(2,"density1",10);
        Density density2= new Density(1, "density5",  2);
        Density density3= new Density(1,"density",5);
        Density density4= new Density(3, "density2",  3);
        Density density5= new Density(4,"density3",5);

        when(densityService.update(any(Density.class))).thenReturn(null);
        when(densityService.update(density)).thenReturn(density);
        when(densityService.update(density1)).thenReturn(density1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(density, densityService.update(density));
        assertEquals(density1,densityService.update(density1));
        // assertEquals(null,);

        assertNull(densityService.update(density2));
        assertNull(densityService.update(density3));
        assertNull(densityService.update(density4));
        assertNull(densityService.update(density5));



    }

    @Test
    public void testdeleteDensity() throws Exception {
        Density density= new Density (1,"density",5);
        Density density1= new Density (2,"density1",10);
        when(densityService.delete(any(Density.class))).thenReturn(null);
        when(densityService.delete(density)).thenReturn(density);
        when(densityService.delete(density1)).thenReturn(density1);
        assertEquals(density,densityService.delete(density));
        assertEquals(density1,densityService.delete(density1));
        assertNull(densityService.delete(new Density(3, "density3", 3)));


    }

    @Test

    public void testgetDensityByID() throws Exception {

        Density density= new Density (1,"density",5);
        Density density1= new Density (2,"density1",10);
        when(densityService.getByID(anyInt())).thenReturn(null);
        when(densityService.getByID(1)).thenReturn(density);
        when(densityService.getByID(2)).thenReturn(density1);
        assertEquals(density,densityService.getByID(1));
        assertEquals(density1,densityService.getByID(2));

        assertNull(densityService.getByID(4));

    }
    @Test

    public  void testgetDensityByType() throws Exception {
        Density density= new Density (1,"density",5);
        Density density1= new Density (2,"density1",10);
        when(densityService.getByType(anyString())).thenReturn(null);
        when(densityService.getByType("density")).thenReturn(density);
        when(densityService.getByType("density1")).thenReturn(density1);
        assertEquals(density,densityService.getByType("density"));
        assertEquals(density1,densityService.getByType("density1"));
        assertNull(densityService.getByType("density2"));
    }

    @Test

    public  void tesDensitygetAll() throws Exception {
        Density density= new Density (1,"density",5);
        Density density1= new Density (2,"density1",10);
        List<Density> densities = new ArrayList<Density>();
        densities.add(density);
        densities.add(density1);
        when(densityService.getAll()).thenReturn(densities);
        assertEquals(densities,densityService.getAll());
        assertEquals(2,densityService.getAll().size());

    }

    @Test

    public void testAddDegredationMechanism() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
        DegradationMechanism  degradationMechanism = new DegradationMechanism("degradationMechanism");
        DegradationMechanism  degradationMechanism1 = new DegradationMechanism("degradationMechanism1");
        DegradationMechanism  degradationMechanism2 = new DegradationMechanism ("degradationMechanism");
        DegradationMechanism  degradationMechanism3 = new DegradationMechanism("degradationMechanism1");

        DegradationMechanism  degradationMechanism4 = new DegradationMechanism(1,"degradationMechanism");
        DegradationMechanism  degradationMechanism5 = new DegradationMechanism(2,"degradationMechanism1");


        when(degradationMechanismService.add(any(DegradationMechanism.class))).thenReturn(null);
        when(degradationMechanismService.add(degradationMechanism)).thenReturn(degradationMechanism4);
        when(degradationMechanismService.add(degradationMechanism1)).thenReturn(degradationMechanism5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(degradationMechanism4, degradationMechanismService.add(degradationMechanism));
        assertEquals(degradationMechanism5,degradationMechanismService.add(degradationMechanism1));

        assertNull(degradationMechanismService.add(degradationMechanism2));
        assertNull(degradationMechanismService.add(degradationMechanism3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdateDegradationMechanism() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)
        DegradationMechanism  degradationMechanism = new DegradationMechanism(1,"degradationMechanismTest1");
        DegradationMechanism  degradationMechanism1 = new DegradationMechanism (2,"degradationMechanismTest2");
        DegradationMechanism  degradationMechanism2 = new DegradationMechanism(1,"degradationMechanismTest3");
        DegradationMechanism  degradationMechanism3 = new DegradationMechanism(1,"degradationMechanismTest1");
        DegradationMechanism  degradationMechanism4= new DegradationMechanism(3,"degradationMechanismTest1");
        DegradationMechanism  degradationMechanism5 = new DegradationMechanism(4,"degradationMechanismTest1");


        when(degradationMechanismService.update(any(DegradationMechanism.class))).thenReturn(null);
        when(degradationMechanismService.update(degradationMechanism )).thenReturn(degradationMechanism);
        when(degradationMechanismService.update(degradationMechanism1)).thenReturn(degradationMechanism1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(degradationMechanism, degradationMechanismService.update(degradationMechanism));
        assertEquals(degradationMechanism1,degradationMechanismService.update(degradationMechanism1));
        // assertEquals(null,);

        assertNull(degradationMechanismService.update(degradationMechanism2));
        assertNull(degradationMechanismService.update(degradationMechanism3));
        assertNull(degradationMechanismService.update(degradationMechanism4));
        assertNull(degradationMechanismService.update(degradationMechanism5));



    }

    @Test
    public void testdeleteDegradationMechanism() throws Exception {
        DegradationMechanism  degradationMechanism = new DegradationMechanism(1,"degradationMechanismTest1");
        DegradationMechanism  degradationMechanism1 = new DegradationMechanism (2,"degradationMechanismTest2");
        when(degradationMechanismService.delete(any(DegradationMechanism.class))).thenReturn(null);
        when(degradationMechanismService.delete(degradationMechanism)).thenReturn(degradationMechanism);
        when(degradationMechanismService.delete(degradationMechanism1)).thenReturn(degradationMechanism1);
        assertEquals(degradationMechanism,degradationMechanismService.delete(degradationMechanism));
        assertEquals(degradationMechanism1,degradationMechanismService.delete(degradationMechanism1));
        assertNull(degradationMechanismService.delete(new DegradationMechanism(3, "degradationMechanismTest1")));


    }

    @Test

    public void testgetDegradationMechanismByID() throws Exception {
        DegradationMechanism  degradationMechanism = new DegradationMechanism(1,"degradationMechanismTest1");
        DegradationMechanism  degradationMechanism1 = new DegradationMechanism (2,"degradationMechanismTest2");
        when(degradationMechanismService.getByID(anyInt())).thenReturn(null);
        when(degradationMechanismService.getByID(1)).thenReturn(degradationMechanism);
        when(degradationMechanismService.getByID(2)).thenReturn(degradationMechanism1);
        assertEquals(degradationMechanism,degradationMechanismService.getByID(1));
        assertEquals(degradationMechanism1,degradationMechanismService.getByID(2));

        assertNull(degradationMechanismService.getByID(4));

    }
    @Test

    public  void testgetDegradationMechanismByType() throws Exception {
        DegradationMechanism  degradationMechanism = new DegradationMechanism(1,"degradationMechanismTest1");
        DegradationMechanism  degradationMechanism1 = new DegradationMechanism (2,"degradationMechanismTest2");
        when(degradationMechanismService.getByType(anyString())).thenReturn(null);
        when(degradationMechanismService.getByType("degradationMechanismTest1")).thenReturn(degradationMechanism);
        when(degradationMechanismService.getByType("degradationMechanismTest2")).thenReturn(degradationMechanism1);
        assertEquals(degradationMechanism, degradationMechanismService.getByType("degradationMechanismTest1"));
        assertEquals(degradationMechanism1,degradationMechanismService.getByType("degradationMechanismTest2"));
        assertNull(degradationMechanismService.getByType("degradationMechanismTest3"));
    }

    @Test

    public  void testgetAllDegradationMechanism() throws Exception {
        DegradationMechanism  degradationMechanism = new DegradationMechanism(1,"degradationMechanismTest1");
        DegradationMechanism  degradationMechanism1 = new DegradationMechanism (2,"degradationMechanismTest2");
        List<DegradationMechanism>  degradationMechanisms= new ArrayList<DegradationMechanism>();
        degradationMechanisms.add(degradationMechanism);
        degradationMechanisms.add(degradationMechanism1);
        when(degradationMechanismService.getAll()).thenReturn(degradationMechanisms);
        assertEquals(degradationMechanisms, degradationMechanismService.getAll());
        assertEquals(2,degradationMechanismService.getAll().size());

    }

    @Test

    public void testAddCompoundFunction() throws Exception {

        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value) {
        ///when(solubility.getType().equals(solubility1.getType())).thenReturn(null);
        CompoundFunction compoundFunction= new CompoundFunction("compoundFunction", 4, 2);
        CompoundFunction compoundFunction1= new CompoundFunction("compoundFunction1",6,3);
        CompoundFunction compoundFunction2= new CompoundFunction("compoundFunction",9,3);
        CompoundFunction compoundFunction3= new CompoundFunction("compoundFunction1",3,1);

        CompoundFunction compoundFunction4= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction5= new CompoundFunction(2, "solubility1", 6, 3);
        when(compoundFunctionService.add(any(CompoundFunction.class))).thenReturn(null);
        when(compoundFunctionService.add(compoundFunction)).thenReturn(compoundFunction4);
        when(compoundFunctionService.add(compoundFunction1)).thenReturn(compoundFunction5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(compoundFunction4, compoundFunctionService.add(compoundFunction));
        assertEquals(compoundFunction5,compoundFunctionService.add(compoundFunction1));

        assertNull(compoundFunctionService.add(compoundFunction2));
        assertNull(compoundFunctionService.add(compoundFunction3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }
/*
    @Test
    public void testupdateCompoundFunction() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)

        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        CompoundFunction compoundFunction2= new CompoundFunction(1, "compoundFunction5", 3, 1);
        CompoundFunction compoundFunction3= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction4= new CompoundFunction(3, "compoundFunction2", 2, 1);
        CompoundFunction compoundFunction5= new CompoundFunction(4,"compoundFunction3",3,2);

        when(compoundFunctionService.update(any(CompoundFunction.class))).thenReturn(null);
        when(compoundFunctionService.update(compoundFunction )).thenReturn(compoundFunction);
        when(compoundFunctionService.update(compoundFunction1)).thenReturn(compoundFunction1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(compoundFunction, compoundFunctionService.update(compoundFunction));
        assertEquals(compoundFunction1,compoundFunctionService.update(compoundFunction1));
        // assertEquals(null,);

        assertNull(compoundFunctionService.update(compoundFunction2));
        assertNull(compoundFunctionService.update(compoundFunction3));
        assertNull(compoundFunctionService.update(compoundFunction4));
        assertNull(compoundFunctionService.update(compoundFunction5));



    }

    @Test
    public void testdeleteCompoundFunction() throws Exception {
        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        when(compoundFunctionService.delete(any(CompoundFunction.class))).thenReturn(null);
        when(compoundFunctionService.delete(compoundFunction)).thenReturn(compoundFunction);
        when(compoundFunctionService.delete(compoundFunction1)).thenReturn(compoundFunction1);
        assertEquals(compoundFunction,compoundFunctionService.delete(compoundFunction));
        assertEquals(compoundFunction1,compoundFunctionService.delete(compoundFunction1));
        assertNull(compoundFunctionService.delete(new CompoundFunction(3, "compoundFunction3", 4, 1)));


    }

    @Test

    public void testgetCompoundFunctionByID() throws Exception {
        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        when(compoundFunctionService.getByID(anyInt())).thenReturn(null);
        when(compoundFunctionService.getByID(1)).thenReturn(compoundFunction);
        when(compoundFunctionService.getByID(2)).thenReturn(compoundFunction1);
        assertEquals(compoundFunction,compoundFunctionService.getByID(1));
        assertEquals(compoundFunction1,compoundFunctionService.getByID(2));

        assertNull(compoundFunctionService.getByID(4));

    }
    @Test

    public  void testgetCompoundFunctionByType() throws Exception {
        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        when(compoundFunctionService.getByType(anyString())).thenReturn(null);
        when(compoundFunctionService.getByType("compoundFunction")).thenReturn(compoundFunction);
        when(compoundFunctionService.getByType("compoundFunction1")).thenReturn(compoundFunction1);
        assertEquals(compoundFunction, compoundFunctionService.getByType("compoundFunction"));
        assertEquals(compoundFunction1,compoundFunctionService.getByType("compoundFunction1"));
        assertNull(compoundFunctionService.getByType("compoundFunction2"));
    }

    @Test

    public  void testgetAllCompoundFunction() throws Exception {
        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        List<CompoundFunction>  compoundFunctions = new ArrayList<CompoundFunction>();
            compoundFunctions.add(compoundFunction);
        compoundFunctions.add(compoundFunction1);
        when(compoundFunctionService.getAll()).thenReturn(compoundFunctions);
        assertEquals(compoundFunctions,compoundFunctionService.getAll());
        assertEquals(2, compoundFunctionService.getAll().size());

    }


    @Test

    public void testAddTabletFormulation() throws Exception {


       // public Excipient(long id, int quantity, List<CompoundFunction> compoundFunctions, Substance substance, float intensity) {
       // public TabletFormulation(long id, String name,List< Excipient > excipients, ) {

        TabletFormulation tabletFormulation = new TabletFormulation("compoundFunction", 4, 2);
        CompoundFunction compoundFunction1= new CompoundFunction("compoundFunction1",6,3);
        CompoundFunction compoundFunction2= new CompoundFunction("compoundFunction",9,3);
        CompoundFunction compoundFunction3= new CompoundFunction("compoundFunction1",3,1);

        CompoundFunction compoundFunction4= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction5= new CompoundFunction(2, "solubility1", 6, 3);
        when(compoundFunctionService.add(any(CompoundFunction.class))).thenReturn(null);
        when(compoundFunctionService.add(compoundFunction)).thenReturn(compoundFunction4);
        when(compoundFunctionService.add(compoundFunction1)).thenReturn(compoundFunction5);
        //when(solubilityService.add(solubility2).getType().equals(solubility)).thenReturn(null);
        //when(solubilityService.add(solubility3).getType().equals(solubility1)).thenReturn(null);
        ;

        assertEquals(compoundFunction4, compoundFunctionService.add(compoundFunction));
        assertEquals(compoundFunction5,compoundFunctionService.add(compoundFunction1));

        assertNull(compoundFunctionService.add(compoundFunction2));
        assertNull(compoundFunctionService.add(compoundFunction3));
        // assertEquals(solubility2,solubilityService.add(solubility2));
        //assertEquals(solubility3,solubilityService.add(solubility3));



    }

    @Test
    public void testupdateCompoundFunction() throws Exception {
        /// public Solubility(long id, String type, float maximumvalueproperty, float minimumvalueproperty, float value)

        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        CompoundFunction compoundFunction2= new CompoundFunction(1, "compoundFunction5", 3, 1);
        CompoundFunction compoundFunction3= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction4= new CompoundFunction(3, "compoundFunction2", 2, 1);
        CompoundFunction compoundFunction5= new CompoundFunction(4,"compoundFunction3",3,2);

        when(compoundFunctionService.update(any(CompoundFunction.class))).thenReturn(null);
        when(compoundFunctionService.update(compoundFunction )).thenReturn(compoundFunction);
        when(compoundFunctionService.update(compoundFunction1)).thenReturn(compoundFunction1);
//        when(solubilityService.update(new Solubility(1,"solubility5",3,1,2)).getId()==solubility.getId()).thenReturn(null);
//        when(solubilityService.update((new Solubility(1,"solubility",4,2,5))).getType().equals(solubility.getType())).thenReturn(null);
        assertEquals(compoundFunction, compoundFunctionService.update(compoundFunction));
        assertEquals(compoundFunction1,compoundFunctionService.update(compoundFunction1));
        // assertEquals(null,);

        assertNull(compoundFunctionService.update(compoundFunction2));
        assertNull(compoundFunctionService.update(compoundFunction3));
        assertNull(compoundFunctionService.update(compoundFunction4));
        assertNull(compoundFunctionService.update(compoundFunction5));



    }

    @Test
    public void testdeleteCompoundFunction() throws Exception {
        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        when(compoundFunctionService.delete(any(CompoundFunction.class))).thenReturn(null);
        when(compoundFunctionService.delete(compoundFunction)).thenReturn(compoundFunction);
        when(compoundFunctionService.delete(compoundFunction1)).thenReturn(compoundFunction1);
        assertEquals(compoundFunction,compoundFunctionService.delete(compoundFunction));
        assertEquals(compoundFunction1,compoundFunctionService.delete(compoundFunction1));
        assertNull(compoundFunctionService.delete(new CompoundFunction(3, "compoundFunction3", 4, 1)));


    }

    @Test

    public void testgetCompoundFunctionByID() throws Exception {
        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        when(compoundFunctionService.getByID(anyInt())).thenReturn(null);
        when(compoundFunctionService.getByID(1)).thenReturn(compoundFunction);
        when(compoundFunctionService.getByID(2)).thenReturn(compoundFunction1);
        assertEquals(compoundFunction,compoundFunctionService.getByID(1));
        assertEquals(compoundFunction1,compoundFunctionService.getByID(2));

        assertNull(compoundFunctionService.getByID(4));

    }
    @Test

    public  void testgetCompoundFunctionByType() throws Exception {
        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        when(compoundFunctionService.getByType(anyString())).thenReturn(null);
        when(compoundFunctionService.getByType("compoundFunction")).thenReturn(compoundFunction);
        when(compoundFunctionService.getByType("compoundFunction1")).thenReturn(compoundFunction1);
        assertEquals(compoundFunction, compoundFunctionService.getByType("compoundFunction"));
        assertEquals(compoundFunction1,compoundFunctionService.getByType("compoundFunction1"));
        assertNull(compoundFunctionService.getByType("compoundFunction2"));
    }

    @Test

    public  void testgetAllCompoundFunction() throws Exception {
        CompoundFunction compoundFunction= new CompoundFunction(1,"compoundFunction",4,2);
        CompoundFunction compoundFunction1= new CompoundFunction(2,"compoundFunction1",7,3);
        List<CompoundFunction>  compoundFunctions = new ArrayList<CompoundFunction>();
        compoundFunctions.add(compoundFunction);
        compoundFunctions.add(compoundFunction1);
        when(compoundFunctionService.getAll()).thenReturn(compoundFunctions);
        assertEquals(compoundFunctions,compoundFunctionService.getAll());
        assertEquals(2, compoundFunctionService.getAll().size());

    }


*/



}
