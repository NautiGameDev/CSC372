import java.util.Random;
/*
 * This class stores string data of a collection of first names, last names, and addresses.
 * The purpose of this class is to randomly generate student names, addresses, and roll numbers for the project.
 * Main program utilizes static methods below when generating an ArrayList of students
 */

public class DataGenerator 
{
    final static String[] studentFirstNames = new String[] {
        "Chris",
        "Fred",
        "James",
        "Michael",
        "Robert",
        "John", 
        "David",
        "William",
        "Richard",
        "Joseph",
        "Thomas",
        "Mary",
        "Patricia",
        "Jennifer",
        "Linda",
        "Elizabeth",
        "Barbara", 
        "Susan", 
        "Jessica"
    };
    final static String[] studentLastNames = new String[] {
        "Russell",
        "Smith",
        "Brown",
        "Jones",
        "Garcia",
        "Miller",
        "Davis",
        "Rodriguez",
        "Martinez",
        "Hernandez",
        "Lopez",
        "Gonzalez",
        "Wilson",
        "Anderson",
        "Thomas",
        "Taylor",
        "Moore",
        "Jackson",
        "Martin"
    };
    final static String[] streets = new String[]
    {
        "Maple",
        "Oak",
        "Pine",
        "Elm",
        "Cedar",
        "Willow",
        "Birch",
        "Aspen",
        "Main",
        "Park",
        "River",
        "Lake",
        "Ocean",
        "Hill",
        "Valley",
        "Meadow",
        "Creekside",
        "Sunset",
        "Sunrise",
        "Grand"
    };

    final static Random random = new Random();

    public static String GenerateStudentName()
    {
        int firstRandomNumber = random.nextInt(studentFirstNames.length- 1);
        int lastRandomNumber = random.nextInt(studentLastNames.length - 1);

        String firstName = studentFirstNames[firstRandomNumber];
        String lastName = studentLastNames[lastRandomNumber];

        return lastName + ", " + firstName;
    }

    public static String GenerateAddress()
    {
        //Generate address number
        String addressNumber = "";

        //Generate three random numbers then concatenate to address number string
        for (int i=0; i<3; i++)
        {
            int randomNumber = random.nextInt(1,9);
            addressNumber += Integer.toString(randomNumber);
        }

        //Choose random street name
        int randomStreetNumber = random.nextInt(streets.length - 1);
        String streetName = streets[randomStreetNumber];
        
        //Choose random street stuffix
        String[] streetType = new String[] {"St.", "Ave.", "Way", "Pl.", "Blvd.", "Rd."};
        int randomTypeNumber = random.nextInt(streetType.length - 1);
        String streetSuffix = streetType[randomTypeNumber]; 

        return addressNumber + " " + streetName + " " + streetSuffix;
    }

    public static int GenerateRollNumber()
    {
        String rollNumberString = "";

        //Generate 5 random numbers then concatenate to string. Return as integer.
        for (int i = 0; i<5; i++)
        {
            int randomNumber = random.nextInt(1,9);
            rollNumberString += Integer.toString(randomNumber);
        }

        return Integer.parseInt(rollNumberString);
    }
}
