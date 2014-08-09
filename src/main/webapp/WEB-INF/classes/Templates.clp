(deftemplate Any
    (slot NameProperty
        (type STRING))
)
(deftemplate PharmaceuticalProduction extends Any
    (multislot QualityControlProperty)
    (slot ProcessProperty
        (type OBJECT))
    (slot FormulationProperty
        (type OBJECT))
    (multislot ManufacturingProblemProperty)
)
(deftemplate TabletProduction extends PharmaceuticalProduction
    (slot TabletProcessProeprty
        (type OBJECT))
    (slot TabletFormulationProperty
        (type OBJECT))
)
(deftemplate SolutionProduction extends PharmaceuticalProduction
    (slot SolutionProcessProperty
        (type OBJECT))
    (slot SolutionFormulationProperty
        (type OBJECT))
)
(deftemplate QualityControl extends Any
)
(deftemplate WeightVariation extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate Hardness extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate DisintegrationTime extends QualityControl
    (slot valueProperty
        (type INTEGER))
)
(deftemplate Friability extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate Thickness extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate DissolutionTest extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate ClarityTest extends QualityControl
    (slot valueProperty
        (type OBJECT))
)
(deftemplate PhysicalProperty extends QualityControl
)
(deftemplate OrganolepticProperty extends PhysicalProperty
    (slot valueProperty
        (type STRING))
)
(deftemplate SizeProperty extends PhysicalProperty
    (slot valueProperty
        (type FLOAT))
)
(deftemplate StabilityTest extends QualityControl
    (slot valueProperty
        (type OBJECT))
)
(deftemplate UniformityOfDosageUnit extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate Precipitation extends QualityControl
    (slot valueProperty
        (type OBJECT))
)
(deftemplate UniformityOfContent extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate pHMeasurment extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate DissolutionProfile extends QualityControl
    (slot valueProperty
        (type FLOAT))
)
(deftemplate ManufacturingProblem extends Any
    (slot ValueProperty
        (type OBJECT))
    (slot characteristicProperty
        (type STRING))
)
(deftemplate CompressionProblem extends ManufacturingProblem
)
(deftemplate FlowabilityProblem extends ManufacturingProblem
)
(deftemplate OxidizedProblem extends ManufacturingProblem
)
(deftemplate CoatingProblem extends ManufacturingProblem
)
(deftemplate Picking extends CoatingProblem
)
(deftemplate OrangePeel extends CoatingProblem
)
(deftemplate Chipping extends CoatingProblem
)
(deftemplate FilmCracking extends CoatingProblem
)
(deftemplate FilmPeeling extends CoatingProblem
)
(deftemplate Delication extends CoatingProblem
)
(deftemplate Dusting extends CoatingProblem
)
(deftemplate Sticking extends CoatingProblem
)
(deftemplate RoughTablet extends CoatingProblem
)
(deftemplate ColorMigration extends CoatingProblem
)
(deftemplate ColorSpecking extends CoatingProblem
)
(deftemplate SolutionProblem extends ManufacturingProblem
)
(deftemplate Caking extends SolutionProblem
)
(deftemplate Crystallization extends SolutionProblem
)
(deftemplate ColorDispersion extends SolutionProblem
)
(deftemplate PrecipitationProblem extends SolutionProblem
)
(deftemplate PoorlyWaterSolubleDrug extends SolutionProblem
)
(deftemplate TabletProblem extends ManufacturingProblem
)
(deftemplate CappingProblem extends TabletProblem
)
(deftemplate PickingProblem extends TabletProblem
)
(deftemplate CrackingProblem extends TabletProblem
)
(deftemplate DrugMigrationProblem extends TabletProblem
)
(deftemplate BindingProblem extends TabletProblem
)
(deftemplate StickingProblem extends TabletProblem
)
(deftemplate DyeMigrationProblem extends TabletProblem
)
(deftemplate DoubleFeedProblem extends TabletProblem
)
(deftemplate FilmingProblem extends TabletProblem
)
(deftemplate LaminatingProblem extends TabletProblem
)
(deftemplate ChippingProblem extends TabletProblem
)
(deftemplate WeightVariationProblem extends TabletProblem
)
(deftemplate HardnessProblem extends TabletProblem
)
(deftemplate DisintregationProblem extends TabletProblem
)
(deftemplate Formulation extends Any
    (multislot ActiveIngredientFunction)
    (multislot PreservativeFunction)
    (multislot BufferingFunction)
    (multislot SurfactantFunction)
    (multislot SolubilizerFunction)
    (multislot ColoringAgentFunction)
    (multislot FlavoringAgentFunction)
    (multislot AntioxidantFunction)
)
(deftemplate SolidFormulation extends Formulation
)
(deftemplate TabletFormulation extends SolidFormulation
    (multislot DiluentFunction)
    (multislot DisintegrantFunction)
    (multislot LubricantFunction)
    (multislot BinderFunction)
    (multislot GlidantFunction)
    (multislot DissolutionRetardantFunction)
    (multislot AntiAdherantFunction)
    (multislot WettingAgentFunction)
    (multislot GranulatingAgentFunction)
    (multislot AdherantFunction)
    (multislot SorbentFunction)
    (multislot CoatingAgentFunction)
)
(deftemplate LiquidFormulation extends Formulation
)
(deftemplate SyrupFormulation extends LiquidFormulation
    (multislot SweeteningAgentFunction)
    (multislot ThickeningAgentFunction)
)
(deftemplate SolutionFormulation extends LiquidFormulation
    (multislot VehicleFunction)
    (multislot ViscosityInducingAgentFunction)
    (multislot SolventFunction)
)
(deftemplate CompoundFunction extends Any
    (slot maxConcentrationProperty
        (type FLOAT))
    (slot minConcentrationProperty
        (type FLOAT))
    (slot TypeProperty
        (type STRING))
)
(deftemplate ActiveIngredientFunction extends CompoundFunction
)
(deftemplate GlidantFunction extends CompoundFunction
)
(deftemplate DisintegrantFunction extends CompoundFunction
)
(deftemplate BufferFunction extends CompoundFunction
)
(deftemplate BinderFunction extends CompoundFunction
)
(deftemplate VehicleFunction extends CompoundFunction
)
(deftemplate SurfactantFunction extends CompoundFunction
)
(deftemplate PreservativeFunction extends CompoundFunction
)
(deftemplate LubricantFunction extends CompoundFunction
)
(deftemplate DiluentFunction extends CompoundFunction
)
(deftemplate AntioxidantFunction extends CompoundFunction
)
(deftemplate FavouringAgentFunction extends CompoundFunction
)
(deftemplate ColouringAgentFunction extends CompoundFunction
)
(deftemplate WettingAgentFunction extends CompoundFunction
)
(deftemplate HygroscopicAgentFunction extends CompoundFunction
)
(deftemplate SweenteningAgentFunction extends CompoundFunction
)
(deftemplate ChelatingAgentFunction extends CompoundFunction
)
(deftemplate pHAdjustmentFunction extends CompoundFunction
)
(deftemplate SolventFunction extends CompoundFunction
)
(deftemplate IsotonicAdjustmentFunction extends CompoundFunction
)
(deftemplate AntiChelatingAgentFunction extends CompoundFunction
)
(deftemplate CoatingAgentFunction extends CompoundFunction
)
(deftemplate PlasticizerFunction extends CompoundFunction
)
(deftemplate ViscosityIncreasingAgentFunction extends CompoundFunction
)
(deftemplate TonicityAgentFunction extends CompoundFunction
)
(deftemplate AffervescentBaseFunction extends CompoundFunction
)
(deftemplate LightProtectingAgentFunction extends CompoundFunction
)
(deftemplate ViscosityInducingAgentFunction extends CompoundFunction
)
(deftemplate SorbentFunction extends CompoundFunction
)
(deftemplate SolubilizerFunction extends CompoundFunction
)
(deftemplate DissolutionRetardantFunction extends CompoundFunction
)
(deftemplate ThickeningAgentFunction extends CompoundFunction
)
(deftemplate AdherantFunction extends CompoundFunction
)
(deftemplate AntiAdherantFunction extends CompoundFunction
)
(deftemplate BufferingFunction extends CompoundFunction
)
(deftemplate ColoringAgentFunction extends CompoundFunction
)
(deftemplate FlavoringAgentFunction extends CompoundFunction
)
(deftemplate GranulatingAgentFunction extends CompoundFunction
)
(deftemplate SweeteningAgentFunction extends CompoundFunction
)
(deftemplate Substance extends Any
    (slot waterSolubilityProperty
        (type OBJECT))
    (multislot StabilityProperty)
    (slot DissolutionProperty
        (type OBJECT))
    (slot PartitionCoefficientProperty
        (type OBJECT))
    (slot PhysicalFormProperty
        (type OBJECT))
    (slot HygroscopicityProperty
        (type OBJECT))
    (slot ParticleProperty
        (type OBJECT))
    (slot AlcoholSolubilityProperty
        (type OBJECT))
    (slot FlowabilityProperty
        (type OBJECT))
    (slot PowderDensityProperty
        (type OBJECT))
    (slot SaltProperty
        (type OBJECT))
    (slot WeightProperty
        (type FLOAT))
    (slot Ionicity
        (type STRING))
)
(deftemplate Water extends Substance
)
(deftemplate Oxygen extends Substance
)
(deftemplate Matter extends Substance
)
(deftemplate WaveMatter extends Matter
)
(deftemplate Light extends WaveMatter
)
(deftemplate DegradationMechanism extends Any
    (multislot DegradationMechanismTypeProperty)
)
(deftemplate KineticReaction extends Any
    (slot KineticReactionTypeProperty
        (type STRING))
)
(deftemplate SaltForm extends Any
    (slot MolecularWeightProperty
        (type FLOAT))
    (slot pKaProperty
        (type OBJECT))
)
(deftemplate Method extends Any
)
(deftemplate GrindingMethod extends Method
)
(deftemplate DryGrinding extends GrindingMethod
)
(deftemplate WetGrinding extends GrindingMethod
)
(deftemplate PulverizationByInterventionMethod extends Method
)
(deftemplate LevigatingMethod extends Method
)
(deftemplate SprayingMethod extends Method
)
(deftemplate HeatingMethod extends Method
)
(deftemplate IndirectHeatingMethod extends HeatingMethod
)
(deftemplate DirectHeatingMethod extends HeatingMethod
)
(deftemplate DryingMethod extends Method
)
(deftemplate FreezeDrymethod extends DryingMethod
)
(deftemplate HeatDryMethod extends DryingMethod
)
(deftemplate StaticHeatDry extends HeatDryMethod
)
(deftemplate DynamicHeatDry extends HeatDryMethod
)
(deftemplate SizeReductionMethod extends Method
)
(deftemplate SeivingMethod extends SizeReductionMethod
    (slot NumberOfSeive
        (type INTEGER))
)
(deftemplate ShearingMethod extends SizeReductionMethod
)
(deftemplate GeometricdilutionMethod extends Method
)
(deftemplate MixingMethod extends Method
)
(deftemplate SubstanceProperty extends Any
)
(deftemplate Solubility extends SubstanceProperty
    (slot MaximumValueProperty
        (type FLOAT))
    (slot MinimumValueProperty
        (type FLOAT))
    (slot SolubilityTypeProperty
        (type STRING))
    (slot solubilityValueProperty
        (type FLOAT))
)
(deftemplate ParticleSize extends SubstanceProperty
    (slot MaximumParticleSizeValueProperty
        (type FLOAT))
    (slot MinimalParticleSizeValueProperty
        (type FLOAT))
    (slot ParticleSizeTypeProperty
        (type STRING))
    (slot ParticleSizeValueProperty
        (type FLOAT))
)
(deftemplate pKa extends SubstanceProperty
    (slot MaximumpKaProperty
        (type FLOAT))
    (slot MinimalpKa
        (type FLOAT))
    (slot pKaTypeProperty
        (type STRING))
    (slot pKaValueProperty
        (type FLOAT))
)
(deftemplate Flowability extends SubstanceProperty
    (slot CompressibilityIndexProperty
        (type OBJECT))
    (slot HausnerRatioProperty
        (type OBJECT))
    (slot AngleOfReposeProperty
        (type OBJECT))
    (slot FlowabilityTypeProperty
        (type STRING))
)
(deftemplate Stability extends SubstanceProperty
    (slot DegradationMechanismProperty
        (type OBJECT))
    (slot KineticReaction
        (type OBJECT))
)
(deftemplate PartitionCoefficient extends SubstanceProperty
    (slot PartitionCoefficientValueProperty
        (type FLOAT))
    (slot PartitionCoefficientTYpeProperty
        (type STRING))
)
(deftemplate Solidstate extends SubstanceProperty
    (slot SolidStateTypeProperty
        (type STRING))
)
(deftemplate Hygroscopicity extends SubstanceProperty
    (slot HygroscopicityTypeProperty
        (type STRING))
)
(deftemplate Density extends SubstanceProperty
    (slot DensityTypeProperty
        (type STRING))
    (slot DensityValueProperty
        (type FLOAT))
)
(deftemplate FlowabilityIndicator extends Any
    (slot MaximumValueProperty
        (type FLOAT))
    (slot MinimumValueProperty
        (type FLOAT))
)
(deftemplate AngleOfRepose extends FlowabilityIndicator
    (slot AngleOfReposeValueProperty
        (type FLOAT))
)
(deftemplate CompressibilityIndex extends FlowabilityIndicator
    (slot BulkDensityProperty
        (type OBJECT))
    (slot TappedDensityProperty
        (type OBJECT))
    (slot CompressiblityIndexValueProperty
        (type FLOAT))
)
(deftemplate HausnerRatio extends FlowabilityIndicator
    (slot BulkDensityProperty
        (type OBJECT))
    (slot TappedDensityProperty
        (type OBJECT))
    (slot HausnerRatioValueProperty
        (type FLOAT))
)
(deftemplate Process extends Any
    (multislot UnitOperationProperty)
)
(deftemplate TabletProcess extends Process
    (multislot MixingUnitOperationProperty)
    (slot ProcessDosageForm
        (type OBJECT))
    (slot TabletProcessTypeProperty
        (type STRING))
    (slot CompressUnitOperationProperty
        (type OBJECT))
)
(deftemplate SolutionProcess extends Process
    (multislot MixingUnitOperationProperty)
)
(deftemplate CoatingProcess extends Process
)
(deftemplate FilmCoat extends CoatingProcess
)
(deftemplate SugarCoat extends CoatingProcess
)
(deftemplate UnitOperation extends Any
    (multislot SubstanceProperty)
    (slot MethodProperty
        (type OBJECT))
)
(deftemplate SizeReduction extends UnitOperation
    (slot SizeReductionMethod
        (type OBJECT))
)
(deftemplate Mixing extends UnitOperation
    (slot MethodProperty
        (type OBJECT))
)
(deftemplate SolidSolidMixing extends Mixing
)
(deftemplate SolidLiquidMixing extends Mixing
)
(deftemplate WetMixing extends SolidLiquidMixing
)
(deftemplate SolidSemiMixing extends Mixing
)
(deftemplate SemiLiquidMixing extends Mixing
)
(deftemplate LiquidLiquidMixing extends Mixing
)
(deftemplate Drying extends UnitOperation
    (slot HeatTemperature
        (type FLOAT))
    (slot MoistureContent
        (type FLOAT))
    (slot MethodProperty
        (type OBJECT))
)
(deftemplate Compression extends UnitOperation
    (slot WeightProperty
        (type FLOAT))
    (slot HardnessProperty
        (type OBJECT))
)
(deftemplate SubCoat extends UnitOperation
)
(deftemplate Grossing extends UnitOperation
)
(deftemplate ColorCoat extends UnitOperation
)
(deftemplate Polishing extends UnitOperation
)
(deftemplate Heating extends UnitOperation
    (slot MaxTempValueProperty
        (type FLOAT))
    (slot MethodProperty
        (type OBJECT))
)
(deftemplate PharmaceuticalDosageForm extends Any
    (slot PharmaceuticalDosageFormType
        (type STRING))
)
(deftemplate ActiveIngredient
    (slot Substance
        (type OBJECT))
    (slot ActiveIngredientFunction
        (type OBJECT))
)
(deftemplate Preservative
    (slot Substance
        (type OBJECT))
    (slot PreservativeFunction
        (type OBJECT))
)
(deftemplate Buffering
    (slot Substance
        (type OBJECT))
    (slot BufferingFunction
        (type OBJECT))
)
(deftemplate Surfactant
    (slot Substance
        (type OBJECT))
    (slot SurfactantFunction
        (type OBJECT))
)
(deftemplate Solubilizer
    (slot Substance
        (type OBJECT))
    (slot SolubilizerFunction
        (type OBJECT))
)
(deftemplate ColoringAgent
    (slot Substance
        (type OBJECT))
    (slot ColoringAgentFunction
        (type OBJECT))
)
(deftemplate FlavoringAgent
    (slot Substance
        (type OBJECT))
    (slot FlavoringAgentFunction
        (type OBJECT))
)
(deftemplate Antioxidant
    (slot Substance
        (type OBJECT))
    (slot AntioxidantFunction
        (type OBJECT))
)
(deftemplate Diluent
    (slot Substance
        (type OBJECT))
    (slot DiluentFunction
        (type OBJECT))
)
(deftemplate Disintegrant
    (slot Substance
        (type OBJECT))
    (slot DisintegrantFunction
        (type OBJECT))
)
(deftemplate Lubricant
    (slot Substance
        (type OBJECT))
    (slot LubricantFunction
        (type OBJECT))
)
(deftemplate Binder
    (slot Substance
        (type OBJECT))
    (slot BinderFunction
        (type OBJECT))
)
(deftemplate Glidant
    (slot Substance
        (type OBJECT))
    (slot GlidantFunction
        (type OBJECT))
)
(deftemplate DissolutionRetardant
    (slot Substance
        (type OBJECT))
    (slot DissolutionRetardantFunction
        (type OBJECT))
)
(deftemplate Antiadherant
    (slot Substance
        (type OBJECT))
    (slot AntiAdherantFunction
        (type OBJECT))
)
(deftemplate WettingAgent
    (slot Substance
        (type OBJECT))
    (slot WettingAgentFunction
        (type OBJECT))
)
(deftemplate GranulatingAgent
    (slot Substance
        (type OBJECT))
    (slot GranulatingAgentFunction
        (type OBJECT))
)
(deftemplate Adherant
    (slot Substance
        (type OBJECT))
    (slot AdherantFunction
        (type OBJECT))
)
(deftemplate Sorbent
    (slot Substance
        (type OBJECT))
    (slot SorbentFunction
        (type OBJECT))
)
(deftemplate CoatingAgent
    (slot Substance
        (type OBJECT))
    (slot CoatingAgentFunction
        (type OBJECT))
)
(deftemplate SweeteningAgent
    (slot Substance
        (type OBJECT))
    (slot SweeteningAgentFunction
        (type OBJECT))
)
(deftemplate ThickeningAgent
    (slot Substance
        (type OBJECT))
    (slot ThickeningAgentFunction
        (type OBJECT))
)
(deftemplate Vehicle
    (slot Substance
        (type OBJECT))
    (slot VehicleFunction
        (type OBJECT))
)
(deftemplate ViscosityInducingAgent
    (slot Substance
        (type OBJECT))
    (slot ViscosityInducingAgentFunction
        (type OBJECT))
)
(deftemplate Solvent
    (slot Substance
        (type OBJECT))
    (slot SolventFunction
        (type OBJECT))
)
