import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

fun main() {
    val year: Int = Calendar.getInstance().get(Calendar.YEAR)
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    val datesOfMoons = arrayOf(LocalDate.of(year,1,17),LocalDate.of(year,2,16),
                                LocalDate.of(year,3,18), LocalDate.of(year,4,16),
                                LocalDate.of(year, 5,16), LocalDate.of(year,6,14),
                                LocalDate.of(year,7,13), LocalDate.of(year,8,11),
                                LocalDate.of(year,9,10), LocalDate.of(year,10,9),
                                LocalDate.of(year,11,8), LocalDate.of (year,12,7))

    print("Please enter your current month as a number: ")
    val month = readLine()!!
    print("Please enter your current day as a number: ")
    val day = readLine()!!

    if (month.toInt() < 1 || month.toInt() > 12){
        println("You have to enter a number between 1 and 12 for the month!")
    } else if (day.toInt() < 1 || day.toInt() > 31){
        println("You have to enter a number between 1 and 31 for the day!")
    } else {
        val holdDay: LocalDate = LocalDate.of(year, month.toInt(), day.toInt())

        for (i in 0..datesOfMoons.size - 1){
            if (holdDay.month == datesOfMoons[i].month){
                if (holdDay.dayOfMonth < datesOfMoons[i].dayOfMonth){
                    println("The next full moon will be on ${datesOfMoons[i].format(formatter)}")
                } else if (holdDay.dayOfMonth == datesOfMoons[i].dayOfMonth){
                    println("the next full moon will be tonight!")
                } else if (holdDay.dayOfMonth >  datesOfMoons[i].dayOfMonth){
                    if (datesOfMoons[i].monthValue == 12){
                        println("the next full moon will be next year. This app cannot predict next years moons. Sorry LMAO!")
                    } else {
                        val temp: LocalDate = LocalDate.of(year,datesOfMoons[i].monthValue + 1,datesOfMoons[i + 1].dayOfMonth)
                        println("The next full moon will be on ${temp.format(formatter)}")
                    }
                }
            }
        }
    }


}