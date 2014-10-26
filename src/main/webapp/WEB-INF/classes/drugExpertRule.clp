(import drugExpertSystem.Model.*)

(deftemplate Substance
    (declare (from-class Substance)
             (include-variables TRUE)))
(deftemplate Excipient
    (declare (from-class Excipient)
             (include-variables TRUE)))

(deftemplate TabletFormulation
    (declare (from-class TabletFormulation)
             (include-variables TRUE)))

(deftemplate SolutionFormulation
    (declare (from-class SolutionFormulation)
             (include-variables TRUE)))