function range(start, end, cb) {
  var i = 0,
    length = (end - start),
    result = Array(length)
  while (i < length) {
    result[i++] = start++
  }
  cb(result)
}

var Gift = {
  name: "",
  count: 0
}

function getGift(n, cb) {
  var gifts = ["Big Oh", "bad", , "random", "thread-safe", "unknown", "monads", "off-by-one", "imprecise", "zero", "pipers", "dumb"],
    gifts2 = ["of n log n", "namings", "functions", "numbers", "functions", "errors", "binding", "errors", "floats", "divisions", "piping", "end users"],
    out = Object.create(Gift)
  out.name = gifts[n - 1] + " " + gifts2[n - 1]
  out.count = n
  cb(out)
}

function getNumber(n, cb) {
  var one = (0.2 + 0.1) / 0.3,
    numbers = [
      ["zero", "a", "too", "three", "four", "five", "six", "seven"],
      [, , , , , , , "eight", one * 9, "ten", "eleven", "twelve"]
    ]
  if (n > 7) {
    cb(numbers[Math.floor(n / 9)][n - 1])
  } else if (n === 4) {
    getNumber(Math.floor(Math.random() * 12), function(number) {
      cb(number)
    })
  } else {
    cb(numbers[Math.floor(n / 9)][n])
  }
}

function whatHappensOnDay(n, cb) {
  var lyrics = ["first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"]
  range(1, n + 1, function(r) {
    cb("On the " + lyrics[n - 1] + " day of Christmas my compiler gave to me", r.reverse())
  })
}

function daysOfChristmas(cb) {
  range(1, 13, function(r) {
    cb(r)
  })
}

daysOfChristmas(function(days) {
  days.forEach(function(day) {
    whatHappensOnDay(day, function(message, giftIDs) {
      process.stdout.write(message + '\n')
      var test = []
      giftIDs.forEach(function(giftID) {
        getGift(giftID, function(gift) {
          getNumber(gift.count, function(number) {
            test.push(number + " " + gift.name)
          })
        })
      })
      process.stdout.write(test.reduce(function(a, b) {
        return a + ",\n" + b
      }).replace(/,\n([^,]*)$/, '\nand $1') + "\n\n")
    })
  })
})