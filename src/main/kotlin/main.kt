/**
 * Константы для первого задания
 */
const val COMISSION_FOR_MONEY_TRANSFER = 0.0075
const val COMISSION_MIN_IN_KOPECKS = 3500

/**
 * Константы для второго задания
 */
const val MELOMANIAC_DISCOUNT = 0.99 //1% скидка
const val MIDDLE_PURCHASES_LEVEL = 100
const val HIGH_PURCHASES_LEVEL = 0.95 //5% скидка

    fun main () {
        //Задание 1
        val amount = 1503775L
        println(comissionForMoneyTransfer(amount))
        println("***********************")
        //Задание 2
        println(humanWordCases(1))
        println(humanWordCases(11))
        println(humanWordCases(21))
        println(humanWordCases(100))
        println(humanWordCases(101))
        println("***********************")
        //Задание 3
        println(melomaniacDiscount(true, 5000.0, 1000.0))
        println(melomaniacDiscount(true, 15000.0, 1000.0))
        println(melomaniacDiscount(true, 999.0, 1000.0))
        println(melomaniacDiscount(false, 5000.0, 1000.0))
        println(melomaniacDiscount(false, 15000.0, 1000.0))
        println(melomaniacDiscount(false, 999.0, 1000.0))
    }

    /**
     * Функция расчета комиссии, задание 1
     */
    private fun comissionForMoneyTransfer (sum : Long) : String {
        val sumOfCommision = (sum * COMISSION_FOR_MONEY_TRANSFER).toInt()
        return if (sumOfCommision < COMISSION_MIN_IN_KOPECKS)
            "Комиссия составит $COMISSION_MIN_IN_KOPECKS копеек"
        else
            "Комиссия составит $sumOfCommision копеек"
    }

/**
 * Лайки/человеки
 */

    private fun humanWordCases(likes : Int) : String {
    val word : String = if (likes % 10 == 1 && likes % 100 != 11)
                            "человеку"
                        else
                            "людям"

        return "Понравилось $likes $word"
    }

/**
 * Меломан
 */

private fun melomaniacDiscount(melomaniacStatus : Boolean, sumOfLastPurchases : Double, sumOfCurrentPurchase : Double) : String {
    var finalSum : Double = if (sumOfLastPurchases >=10001) {
                                sumOfCurrentPurchase * HIGH_PURCHASES_LEVEL
                            } else if (sumOfLastPurchases in 1001.0..10000.99)
                                sumOfCurrentPurchase - 100
                            else
                                sumOfCurrentPurchase

    if (melomaniacStatus) finalSum *= MELOMANIAC_DISCOUNT

    return "Итого к оплате $finalSum"
}

