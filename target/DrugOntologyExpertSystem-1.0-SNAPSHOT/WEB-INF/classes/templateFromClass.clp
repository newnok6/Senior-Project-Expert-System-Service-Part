(import drugExpertSystem.substance.Substance)
(import drugExpertSystem.substance.Entity.SubstanceFunction.SubstanceFunction)
(import drugExpertSystem.excipient.Excipient)
(import drugExpertSystem.formulation.Formulation)
(import drugExpertSystem.Production.Production)
(import drugExpertSystem.Production.Process.PharmaceuticalProcess)
(import drugExpertSystem.Production.UnitOperation.UnitOperation)


(deftemplate Substance
    (declare (from-class Substance)
             (include-variables TRUE)))
(deftemplate SubstanceFunction
    (declare (from-class SubstanceFunction)
             (include-variables TRUE)))
(deftemplate Excipient
    (declare (from-class Excipient)
             (include-variables TRUE)))
(deftemplate Formulation
    (declare (from-class Formulation)
             (include-variables TRUE)))
(deftemplate Production
    (declare (from-class Production)
             (include-variables TRUE)))
(deftemplate PharmaceuticalProcess
    (declare (from-class PharmaceuticalProcess)
             (include-variables TRUE)))
(deftemplate UnitOperation
    (declare (from-class UnitOperation)
             (include-variables TRUE)))


