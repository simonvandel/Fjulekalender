//
//  main.swift
//  Twelve days of christmas
//
//  Created by Simon Vandel Sillesen on 01/12/14.
//  Copyright (c) 2014 Simon Vandel Sillesen. All rights reserved.
//

import Foundation


let numbers = ["a", "too", "three", "four", "five", "six", "seven", "eight", "9.000000000000002", "ten", "eleven", "twelve"]

let days = ["first",
				"second",
				"third",
				"fourth",
				"fifth",
				"sixth",
				"seventh",
				"eighth",
				"ninth",
				"tenth",
				"eleventh",
				"twelfth"]

let lyrics = ["Big Oh of n log n",
				"bad namings",
				"undefined functions",
				"random numbers",
				"thread-safe functions",
				"unknown errors",
				"Monads binding",
				"off-by-one errors",
				"Imprecise Floats",
				"zero divisions",
				"Pipers Piping",
				"Dumb end users"]

func getLyricLine(dayIndex: Int, numberIndex: Int) -> String {
    var string = ""
    if numberIndex == 0 && dayIndex != 0 {
        string += "and "
    }

    switch numberIndex {
    case 3:
        let randomDay = arc4random_uniform(UInt32(numbers.count))
        string += "\(numbers[Int(randomDay)]) \(lyrics[numberIndex])"
    case 7:
        string += "\(numbers[numberIndex - 1]) \(lyrics[numberIndex])"
    default:
        string += "\(numbers[numberIndex]) \(lyrics[numberIndex])"
    }
    
    return string
}

for (dayIndex, day) in enumerate(days) {
    println("On the \(day) day of Christmas my compiler gave to me")
    
    for var numberIndex = dayIndex; numberIndex >= 0; numberIndex-- {
        println(getLyricLine(dayIndex, numberIndex))
    }
    
    println()
}



