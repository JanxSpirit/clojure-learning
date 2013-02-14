(ns clojure-learning.core)

;; quicksort
(defn qsort
  [l]
  (if (= (count l) 0) l
      (let [pivoti (first l)
            lt (filter #(< % pivoti) l)
            gt (filter #(> % pivoti) l)
            eq (filter #(= % pivoti) l)]
        (concat (qsort lt) eq (qsort gt)))))

(qsort [1 5 7 3 4 6 3])

;;string has all unique characters
(defn allUnique? [s]
  ((fn inner [l m]
       (if (< (count l) 1) true
           (let [[h & rest] l]
             (if (contains? m h) false
                 (inner rest (assoc m h 1))))))
     s {}))

(allUnique? "grep and")

;;reverse C style string
(defn revc [s]
  (if (= 1 (count s))
    (first s)
    (let [[h & rest] s]
      (str (revc rest) h))))

(revc "gregg")

;;remove duplicate characters
