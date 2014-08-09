(deftemplate PizzaTopping
	(slot name
		(type STRING))
	(slot vegetarian)
)
(deftemplate PizzaBase
	(slot name
		(type STRING))
	(slot size
		(type INTEGER))
)
(deftemplate ThinandCripy
	(slot name
		(type STRING))
	(slot size
		(type INTEGER))
)
(deftemplate DeepandPan
	(slot name
		(type STRING))
	(slot size
		(type INTEGER))
)
(deftemplate Pizza
	(slot name
		(type STRING))
	(slot base
		(type OBJECT))
	(multislot topping)
)