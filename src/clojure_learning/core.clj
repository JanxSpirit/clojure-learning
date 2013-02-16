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
(defn remDups [s]
  ((fn inner [accum s found]
     (if (= 0 (count s))
       accum
       (let [[h & rest] s]
         (if (bit-test found (int h))
           (inner accum rest found)
           (inner (str accum h) rest (bit-set found (int h))))))) "" s (long 0)))

(remDups "Janx Spirit")

;;are two strings anagrams
(defn anagrams? [s1 s2] (= (sort s1) (sort s2)))

;;replace all spaces with %20
(defn escapeSpaces [s]
  ((fn inner [accum s]
     (if (= 0 (count s)) accum
         (let [[h & rest] s]
           (inner
            (str accum
                 (if (= h \space) "%20" h)) 
            rest)))) "" s))

(escapeSpaces "All the young dudes")

;;rotate square matrix
(defn rotate-left [s]
  (reverse (apply mapv vector s)))

(defn rotate-right [s]
  (apply mapv vector (reverse s)))

(rotate-left [[1 2 3 4] [5 6 7 8] [9 10 11 12] [13 14 15 16]])
(rotate-right [[1 2 3 4] [5 6 7 8] [9 10 11 12] [13 14 15 16]])
