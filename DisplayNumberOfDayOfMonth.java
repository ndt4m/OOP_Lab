import java.util.Scanner;
public class DisplayNumberOfDayOfMonth 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int numerical_month = -1;
        while(numerical_month == -1)
        {
            System.out.println("Enter month: ");
            String month = input.nextLine();
            switch (month) 
            {
                case "January":
                case "Jan.":
                case "Jan":
                case "1":
                    numerical_month = 1;
                    break;
                case "February":
                case "Feb.":
                case "Feb":
                case "2":
                    numerical_month = 2;
                    break;
                case "March":
                case "Mar.":
                case "Mar":
                case "3":
                    numerical_month = 3;
                    break;
                case "April":
                case "Apr.":
                case "Apr":
                case "4":
                    numerical_month = 4;
                    break;
                case "May":
                case "5":
                    numerical_month = 5;
                    break;
                case "June":
                case "Jun.":
                case "Jun":
                case "6":
                    numerical_month = 6;
                    break;
                case "July":
                case "Jul.":
                case "Jul":
                case "7":
                    numerical_month = 7;
                    break;
                case "August":
                case "Aug.":
                case "Aug":
                case "8":
                    numerical_month = 8;
                    break;
                case "September":
                case "Sep.":
                case "Sep":
                case "9":
                    numerical_month = 9;
                    break;
                case "October":
                case "Oct.":
                case "Oct":
                case "10":
                    numerical_month = 10;
                    break;
                case "November":
                case "Nov.":
                case "Nov":
                case "11":
                    numerical_month = 11;
                    break;
                case "December":
                case "Dec.":
                case "Dec":
                case "12":
                    numerical_month = 12;
                    break;
                default:
                    System.out.println("Invalid month.");
            }
        }
        
        int year = -1;
        while(true)
        {
            System.out.println("Enter year: ");
            year = input.nextInt();
            if (year < 0)
            {
                System.out.println("Invalid year. Year must be an non-negative number");
            } 
            else
            {
                break;
            }
        }
        
        int day;
        switch (numerical_month)
        {
            case 2:
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
                {
                    day = 29;
                    break;
                }
                else
                {
                    day = 28;
                    break;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            default:
                day = 31;
                break;
        }
        System.out.printf("The number of days in %d/%d is %d", numerical_month, year, day);
    }
}
