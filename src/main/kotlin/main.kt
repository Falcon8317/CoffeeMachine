import kotlin.system.exitProcess

fun main() {
    val machine = CoffeeMachine()
    do {
        machine.printActions()
        machine.machineAction(readLine()!!.toString())
    } while (true)
}

class CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var cups = 9
    private var money = 550

    private fun printStatus() {
        println("""The coffee machine has:
$water ml of water
$milk ml of milk
$coffeeBeans g of coffee beans
$cups disposable cups
$$money of money""")
        println()
    }

    fun machineAction(a: String) {
        when (a) {
            "buy" -> {
                println()
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
                when (readLine()!!.toString()) {
                    "1" -> {
                        if (water - 250 >= 0 && coffeeBeans - 16 >= 0 && cups > 0)  {
                            money += 4
                            water -= 250
                            coffeeBeans -= 16
                            cups--
                            println("I have enough resources, making you a coffee!")
                            println()
                        } else if (water - 250 < 0) {
                            println("Sorry, not enough water!")
                            println()
                        } else if (coffeeBeans - 16 < 0) {
                            println("Sorry, not enough coffee beans!")
                            println()
                        } else {
                            println("Sorry, not enough cups!")
                            println()
                        }
                    }
                    "2" -> {
                        if (water - 350 >= 0 && milk - 75 >= 0 && coffeeBeans - 20 >= 0 && cups > 0) {
                            water -= 350
                            milk -= 75
                            coffeeBeans -= 20
                            cups--
                            money += 7
                            println("I have enough resources, making you a coffee!")
                            println()
                        } else if (water - 350 < 0) {
                            println("Sorry, not enough water!")
                            println()
                        } else if (milk - 75 < 0) {
                            println("Sorry, not enough milk!")
                            println()
                        } else if (coffeeBeans - 20 < 0) {
                            println("Sorry, not enough coffee beans!")
                            println()
                        } else {
                            println("Sorry, not enough cups!")
                            println()
                        }
                    }
                    "3" -> { if (water - 200 >= 0 && milk - 100 >= 0 && cups - 1 > 0) {
                        water -= 200
                        milk -= 100
                        coffeeBeans -= 12
                        cups--
                        money += 6
                        println("I have enough resources, making you a coffee!")
                        println()
                    } else if (water - 200 < 0) {
                        println("Sorry, not enough water!")
                        println()
                    } else if (milk - 100 < 0) {
                        println("Sorry, not enough milk!")
                        println()
                    } else if (coffeeBeans - 12 < 0) {
                        println("Sorry, not enough coffee beans!")
                        println()
                    } else {
                        println("Sorry, not enough cups!")
                    }
                    }
                    "back" -> return
                }
            }
            "fill" -> {
                println()
                println("Write how many ml of water you want to add:")
                water += readLine()!!.toInt()
                println("Write how many ml of milk you want to add:")
                milk += readLine()!!.toInt()
                println("Write how many grams of coffee beans you want to add:")
                coffeeBeans += readLine()!!.toInt()
                println("Write how many disposable cups you want to add:")
                cups += readLine()!!.toInt()
                println()
            }
            "take" -> {
                println()
                println("I gave you $$money")
                money = 0
                println()
            }
            "exit" -> exitProcess(0)

            "remaining" -> {
                println()
                printStatus()
            }
        }
    }
    fun printActions() {
        println("Write action (buy, fill, take, remaining, exit):")
    }
}