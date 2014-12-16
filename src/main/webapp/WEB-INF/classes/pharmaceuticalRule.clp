
(defrule rule1
    (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
    (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
    ;; API in the generic production
    ?s <- (Substance (name ?name) (OBJECT ?apis))
    ?e <- (Excipient (substance ?apis) (OBJECT ?exp))
    (test (?explist contains ?exp))
    ;; API from user
    (Substance (name ?name) (OBJECT ?apisfu))
    (Excipient (source "user") (substance ?apisfu)(usedWeight ?weight) (OBJECT ?uexci))
=>
    (modify ?s (name ?name))
    (modify ?e (usedWeight ?weight))
    (printout t "fire rule-1 ")
)

(defrule rule2
    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
    (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
    ;; API in the generic production
    ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
        (Substance (name ?name) (OBJECT ?apis))
        (SubstanceFunction (functionName "api")(OBJECT ?apisf))
        (test (?sfl contains ?apisf))
        (test (?explist contains ?exp))

     ;; Formulation form expert
     ?of <-(Formulation (excipient ?explist2)(source "database") (OBJECT ?for2))
         ;; API in the expert formulation
         ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(OBJECT ?exp2))
             (Substance (name ?name) (OBJECT ?apis2))
             (SubstanceFunction (functionName "api")(OBJECT ?apisf2))
             (test (?sfl2 contains ?apisf2))
              (test (?explist2 contains ?exp2))
=>

    (modify ?p (formulation ?for2))
    ;;(retract ?of)
    (modify ?of (source "inference"))
    (printout t "fire rule-2 ")
)

(defrule rule3
    ;; this rule set the concentration of disintegrant from the disintegration time(<180) factor.
    (Production (type "original")(distegretionTime ?dt))

    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
        (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
        ;; disintegrant in the generic formulatiom
        ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
            (Substance (name ?name) (OBJECT ?apis))
            (SubstanceFunction (functionName "disintegrant")(OBJECT ?apisf))
            (test (?sfl contains ?apisf))
            (test (?explist contains ?exp))

        ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(maxWeight ?max) (minWeight ?min) (source "databaseE") (OBJECT ?exp2))
                (Substance (name ?name) (OBJECT ?apis2))
                (SubstanceFunction (functionName "disintegrant")(OBJECT ?apisf2))
                (test (?sfl2 contains ?apisf2))

        (test (< ?dt 180))

=>
    (modify ?e (usedWeight ?max))
    (printout t "fire rule-3 ")
)

(defrule rule4
    ;; this rule set the concentration of disintegrant from the disintegration time(>300) factor.
    (Production (type "original")(distegretionTime ?dt))

    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
        (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
        ;; disintegrant in the generic formulatiom
        ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
            (Substance (name ?name) (OBJECT ?apis))
            (SubstanceFunction (functionName "disintegrant")(OBJECT ?apisf))
            (test (?sfl contains ?apisf))
            (test (?explist contains ?exp))

        ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(maxWeight ?max) (minWeight ?min) (source "databaseE") (OBJECT ?exp2))
                (Substance (name ?name) (OBJECT ?apis2))
                (SubstanceFunction (functionName "disintegrant")(OBJECT ?apisf2))
                (test (?sfl2 contains ?apisf2))

        (test (> ?dt 300))

=>
    (modify ?e (usedWeight ?min))
    (printout t "fire rule-4 ")
)

(defrule rule5
    ;; this rule set the concentration of disintegrant from the disintegration time(181-300) factor.
    (Production (type "original")(distegretionTime ?dt))

    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
        (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
        ;; disintegrant in the generic formulatiom
        ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
            (Substance (name ?name) (OBJECT ?apis))
            (SubstanceFunction (functionName "disintegrant")(OBJECT ?apisf))
            (test (?sfl contains ?apisf))
            (test (?explist contains ?exp))

        ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(maxWeight ?max) (minWeight ?min) (source "databaseE") (OBJECT ?exp2))
                (Substance (name ?name) (OBJECT ?apis2))
                (SubstanceFunction (functionName "disintegrant")(OBJECT ?apisf2))
                (test (?sfl2 contains ?apisf2))

        (test (> ?dt 180))
        (test (< ?dt 300))

=>
    (modify ?e (usedWeight (/ (+ ?max ?min) 2)))
    (printout t "fire rule-5 ")
)
(defrule rule6
     ;; this rule set the concentration of binder from the friability(< 0.3) factor.
    (Production (type "original")(friability ?fa))

    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
        (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
        ;; disintegrant in the generic formulatiom
        ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
            (Substance (name ?name) (OBJECT ?apis))
            (SubstanceFunction (functionName "binder")(OBJECT ?apisf))
            (test (?sfl contains ?apisf))
            (test (?explist contains ?exp))

        ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(maxWeight ?max) (minWeight ?min) (source "databaseE") (OBJECT ?exp2))
                (Substance (name ?name) (OBJECT ?apis2))
                (SubstanceFunction (functionName "binder")(OBJECT ?apisf2))
                (test (?sfl2 contains ?apisf2))

        (test (< ?fa 0.3))

=>
    (modify ?e (usedWeight ?max))
    (printout t "fire rule-6 ")
)

(defrule rule7
     ;; this rule set the concentration of binder from the friability(> 0.85) factor.
    (Production (type "original")(friability ?fa))

    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
        (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
        ;; disintegrant in the generic formulatiom
        ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
            (Substance (name ?name) (OBJECT ?apis))
            (SubstanceFunction (functionName "binder")(OBJECT ?apisf))
            (test (?sfl contains ?apisf))
            (test (?explist contains ?exp))

        ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(maxWeight ?max) (minWeight ?min) (source "databaseE") (OBJECT ?exp2))
                (Substance (name ?name) (OBJECT ?apis2))
                (SubstanceFunction (functionName "binder")(OBJECT ?apisf2))
                (test (?sfl2 contains ?apisf2))

        (test (> ?fa 0.85))

=>
    (modify ?e (usedWeight ?min))
    (printout t "fire rule-7 ")
)

(defrule rule8
     ;; this rule set the concentration of binder from the friability(0.3-0.85) factor.
    (Production (type "original")(friability ?fa))

    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
        (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
        ;; disintegrant in the generic formulatiom
        ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
            (Substance (name ?name) (OBJECT ?apis))
            (SubstanceFunction (functionName "binder")(OBJECT ?apisf))
            (test (?sfl contains ?apisf))
            (test (?explist contains ?exp))

        ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(maxWeight ?max) (minWeight ?min) (source "databaseE") (OBJECT ?exp2))
                (Substance (name ?name) (OBJECT ?apis2))
                (SubstanceFunction (functionName "binder")(OBJECT ?apisf2))
                (test (?sfl2 contains ?apisf2))

        (test (> ?fa 0.3))
        (test (< ?fa 0.85))
=>
    (modify ?e (usedWeight (/ (+ ?max ?min) 2)))
    (printout t "fire rule-8 ")
)


(defrule rule9
    ;; this rule set the concentration of lubricant.
    (Production (type "original")(friability ?fa))

    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
        (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
        ;; disintegrant in the generic formulatiom
        ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
            (Substance (name ?name) (OBJECT ?apis))
            (SubstanceFunction (functionName "lubricant")(OBJECT ?apisf))
            (test (?sfl contains ?apisf))
            (test (?explist contains ?exp))

        ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(maxWeight ?max) (minWeight ?min) (source "databaseE") (OBJECT ?exp2))
                (Substance (name ?name) (OBJECT ?apis2))
                (SubstanceFunction (functionName "lubricant")(OBJECT ?apisf2))
                (test (?sfl2 contains ?apisf2))

=>
    (modify ?e (usedWeight ?min))
    (printout t "fire rule-9 ")
)

(defrule rule10
    (Production (type "original")(friability ?fa))

    ?p <- (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
        (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
        ;; disintegrant in the generic formulatiom
        ?e <- (Excipient (substance ?apis) (substanceFunctions ?sfl)(OBJECT ?exp))
            (Substance (name ?name) (OBJECT ?apis))
            (SubstanceFunction (functionName "buffering agent")(OBJECT ?apisf))
            (test (?sfl contains ?apisf))
            (test (?explist contains ?exp))

        ?e2 <- (Excipient (substance ?apis2) (substanceFunctions ?sfl2)(maxWeight ?max) (minWeight ?min) (source "databaseE") (OBJECT ?exp2))
                (Substance (name ?name) (OBJECT ?apis2))
                (SubstanceFunction (functionName "buffering agent")(OBJECT ?apisf2))
                (test (?sfl2 contains ?apisf2))

=>
    (modify ?e (usedWeight ?min))
    (printout t "fire rule-10 ")
)

(defrule rule90
    (Production (type "generic") (formulation ?for)(OBJECT ?gtp))
    (Formulation (excipient ?explist)(source "inference") (OBJECT ?for))
    ;; API in the generic production
    ?s <- (Substance (name ?name) (OBJECT ?apis))
    ?e <- (Excipient (substance ?apis) (OBJECT ?exp))
    (test (?explist contains ?exp))
    ;; API from user
    ?suser <- (Substance (name ?name)(flowability ?flow) (OBJECT ?apisfu))
    (Excipient (source "user") (substance ?apisfu)(usedWeight ?weight) (OBJECT ?uexci))
=>
    (modify ?s (name ?name)(flowability ?flow))
    (modify ?e (usedWeight ?weight))
    (printout t "fire rule-1 ")
)

(defrule rule91
    ;; this rule set the pharamceutical process name from flowability and compressibility.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
           (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
          (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (flowability "passable")(OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (OBJECT ?processobject))
=>
    (modify ?process (name "Wet granulation"))
    (printout t "fire rule-91 ")
)

(defrule rule92
    ;; this rule set the pharamceutical process name from flowability and compressibility.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
           (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
          (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (flowability "excellent")(OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (OBJECT ?processobject))
=>
    (modify ?process (name "direct compression"))
    (printout t "fire rule-92 ")
)

(defrule rule93
    ;; this rule set the pharamceutical process name from flowability and compressibility.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
           (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
          (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (flowability "good")(OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (OBJECT ?processobject))
=>
    (modify ?process (name "direct compression"))
    (printout t "fire rule-93 ")
)

(defrule rule94
    ;; this rule set the pharamceutical process name from flowability and compressibility.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
           (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
          (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (flowability "fair")(OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (OBJECT ?processobject))
=>
    (modify ?process (name "Wet granulation"))
    (printout t "fire rule-94 ")
)

(defrule rule95
    ;; this rule set the pharamceutical process name from flowability and compressibility.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
           (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
          (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (flowability "poor")(OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (OBJECT ?processobject))
=>
    (modify ?process (name "Wet granulation"))
    (printout t "fire rule-95 ")
)

(defrule rule96
    ;; this rule set the pharamceutical process name from flowability and compressibility.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
           (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
          (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (flowability "veryPoor")(OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (OBJECT ?processobject))
=>
    (modify ?process (name "Wet granulation"))
    (printout t "fire rule-96 ")
)

(defrule rule97
    ;; this rule set the pharamceutical process name from flowability and compressibility.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
           (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
          (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (flowability "veryveryPoor")(OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (OBJECT ?processobject))
=>
    (modify ?process (name "Wet granulation"))
    (printout t "fire rule-97 ")
)

(defrule rule101
    ;; this rule set the unitoperation of the direct compression.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
          ?f <- (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
         ?e <- (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (unitOperations ?unitOperationList)(name "direct compression")(OBJECT ?processobject))
        ?u1 <- (UnitOperation (sequence 1) (OBJECT ?unitOperation1))
        (test (?unitOperationList contains ?unitOperation1))

=>
   ;;(bind ?explistN  (add ?exp))
    ;;(bind ?explistN (create$ ))
    ;;(for (bind ?i 1) (< ?i (length$ (list ?explist))) (++ ?i)
                                    ;; (create$ (nth$ ?i (list ?explist))))
    ;;(bind ?explistN (create$ (fact-slot-value ?f excipient)))
    ;;?explistN <- (OBJECT ?explist)
    ;;(bind ?explistN (list ?explist))
    ;;(list ?explistN)
    ;;(?explistN addAll ?explist)
    ;;(?explistN remove ?e)
    ;;(member$ ?e ?explistN)
    ;;(complement$ ?explistN (list ?e))

    ;;(bind ?explistN (list ?explist))
    ;;(bind ?memberNum (member$ ?exp ?explistN))
    ;;(delete$ ?explistN ?memberNum ?memberNum )
    (modify ?u1 (name "mixing"))
    ;;(modify ?u1 (excipients ?explistN))

    (printout t "fire rule-101 ")
)

(defrule rule102
    ;; this rule set the unitoperation of the direct compression.
    ?p <- (Production (type "generic") (formulation ?for)(pharmaceuticalProcess ?processobject))
           (Formulation (excipient ?explist) (OBJECT ?for))
        ;; API in the generic production
          (Excipient (substance ?substance) (substanceFunctions ?substancefunctionlist)(OBJECT ?exp))
          (Substance (name ?name) (OBJECT ?substance))
          (SubstanceFunction (functionName "api")(OBJECT ?substancefunction))
          (test (?substancefunctionlist contains ?substancefunction))
          (test (?explist contains ?exp))
        ?process <- (PharmaceuticalProcess (unitOperations ?unitOperationList)(name "direct compression")(OBJECT ?processobject))
        ?u2 <- (UnitOperation (sequence 2) (OBJECT ?unitOperation2))
        (test (?unitOperationList contains ?unitOperation2))
=>
    (modify ?u2 (name "compression"))
    (printout t "fire rule-102 ")
)
