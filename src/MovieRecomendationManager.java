import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class MovieRecomendationManager {
    private Set<Movie> movies;
    private Set<Director> directors;
    private Set<Actor> actors;
    private Set<User> users;
    private User currentUser;

    public MovieRecomendationManager(Set<Movie> movies, Set<Director> directors, Set<Actor> actors, Set<User> users) {
        this.movies = movies;
        this.directors = directors;
        this.actors = actors;
        this.users = users;
    }

    public MovieRecomendationManager() {
        movies = new HashSet<>();
        users = new HashSet<>();
        directors = new HashSet<>();
        actors = new HashSet<>();
        currentUser = null;
        addDefaultDirectors(createDefaultDirectors());
        addDefaultActors(createDefaultActors());
        addDefaultMovies();
        addUser(new User("admin", "bustiad@gmail.com", "@dm1n"));
        addUser(new User(1, "Èrik", LocalDate.of(2004, 10, 15), "Spanish", "erik", "sonwerik@mail.com", "miau"));
        addUser(new User(2, "Jordi", LocalDate.of(2000, 1, 1), "Spanish", "jordi", "jordi@mail.com", "password"));
        addUser(new User(3, "Alam", LocalDate.of(2006, 1, 1), "Spanish", "alam", "alam@mail.com", "contraseña"));
        addUser(new User(4, "Joan", LocalDate.of(2006, 1, 1), "Spanish", "joan", "joan@mail.com", "contrasenya"));
        findUserByUsername("erik").setFavouriteMovie(filterMovies("Django Unchained").getFirst());
    }

    private Set<Director> createDefaultDirectors() {
        Director christopherNolan = new Director(0, "Christopher Nolan", LocalDate.of(1970, 7, 30), "British");
        Director francisFordCoppola = new Director(1, "Francis Ford Coppola", LocalDate.of(1939, 4, 7), "U.S.");
        Director quentinTarantino = new Director(2, "Quentin Tarantino", LocalDate.of(1963, 3, 27), "U.S.");
        Director martinScorsese = new Director(3, "Martin Scorsese", LocalDate.of(1942, 11, 17), "U.S.");
        Director toddPhillips = new Director(4, "Todd Phillips", LocalDate.of(1970, 12, 20), "U.S.");
        Director jonathanDemme = new Director(5, "Jonathan Demme", LocalDate.of(1944, 2, 22), "U.S.");
        Director alfredHitchcock = new Director(6, "Alfred Hitchcock", LocalDate.of(1899, 8, 13), "British");
        Director stanleyKubrick = new Director(7, "Stanley Kubrick", LocalDate.of(1928, 7, 26), "U.S.");
        Director davidFrankel = new Director(8, "David Frankel", LocalDate.of(1959, 4, 2), "American");
        Director chrisColumbus = new Director(9, "Chris Columbus", LocalDate.of(1958, 9, 10), "American");
        Director alfonsoCuaron = new Director(10, "Alfonso Cuarón", LocalDate.of(1961, 11, 28), "Mexican");
        Director mikeNewell = new Director(11, "Mike Newell", LocalDate.of(1942, 3, 28), "British");
        Director davidYates = new Director(12, "David Yates", LocalDate.of(1963, 10, 8), "British");
        Director robertoBenigni = new Director(13, "Roberto Benigni", LocalDate.of(1952, 10, 27), "Italian");
        Director peterWeir = new Director(14, "Peter Weir", LocalDate.of(1944, 8, 21), "Australian");
        Director frankDarabont = new Director(15, "Frank Darabont", LocalDate.of(1959, 1, 28), "American");
        Director romanPolanski = new Director(16, "Roman Polanski", LocalDate.of(1933, 8, 18), "Polish");
        Director davidFincher = new Director(17, "David Fincher", LocalDate.of(1962, 8, 28), "American");
        Director ridleyScott = new Director(18, "Ridley Scott", LocalDate.of(1937, 11, 30), "British");
        Director peterJackson = new Director(19, "Peter Jackson", LocalDate.of(1961, 10, 31), "New Zealander");
        Director tateTaylor = new Director(20, "Tate Taylor", LocalDate.of(1969, 6, 3), "American");
        Director angLee = new Director(21, "Ang Lee", LocalDate.of(1954, 10, 23), "Taiwanese");
        Director steveMcQueen = new Director(22, "Steve McQueen", LocalDate.of(1969, 10, 9), "British");
        Director jamesMarsh = new Director(23, "James Marsh", LocalDate.of(1963, 4, 30), "British");
        Director mortenTyldum = new Director(24, "Morten Tyldum", LocalDate.of(1967, 5, 19), "Norwegian");
        Director joshBoone = new Director(25, "Josh Boone", LocalDate.of(1979, 4, 5), "American");
        Director benStiller = new Director(26, "Ben Stiller", LocalDate.of(1965, 11, 30), "American");
        Director bazLuhrmann = new Director(27, "Baz Luhrmann", LocalDate.of(1962, 9, 17), "Australian");
        Director wesAnderson = new Director(28, "Wes Anderson", LocalDate.of(1969, 5, 1), "American");
        Director alejandroGonzalezInarritu = new Director(29, "Alejandro González Iñárritu", LocalDate.of(1963, 8, 15), "Mexican");
        Director tomMcCarthy = new Director(30, "Tom McCarthy", LocalDate.of(1966, 6, 7), "American");
        Director tomHooper = new Director(31, "Tom Hooper", LocalDate.of(1972, 10, 5), "British");
        Director guillermoDelToro = new Director(32, "Guillermo del Toro", LocalDate.of(1964, 10, 9), "Mexican");
        Director martinMcDonagh = new Director(33, "Martin McDonagh", LocalDate.of(1970, 3, 26), "British");
        Director lucaGuadagnino = new Director(34, "Luca Guadagnino", LocalDate.of(1971, 8, 10), "Italian");
        Director bradleyCooper = new Director(35, "Bradley Cooper", LocalDate.of(1975, 1, 5), "American");
        Director bryanSinger = new Director(36, "Bryan Singer", LocalDate.of(1965, 9, 17), "American");
        Director samMendes = new Director(37, "Sam Mendes", LocalDate.of(1965, 8, 1), "British");
        Director bongJoonHo = new Director(38, "Bong Joon-ho", LocalDate.of(1969, 9, 14), "South Korean");
        Director gretaGerwig = new Director(39, "Greta Gerwig", LocalDate.of(1983, 8, 4), "American");
        Director rianJohnson = new Director(40, "Rian Johnson", LocalDate.of(1973, 12, 17), "American");
        Director chloeZhao = new Director(41, "Chloé Zhao", LocalDate.of(1982, 3, 31), "Chinese");
        Director denisVilleneuve = new Director(42, "Denis Villeneuve", LocalDate.of(1967, 10, 3), "Canadian");
        Director janeCampion = new Director(43, "Jane Campion", LocalDate.of(1954, 4, 30), "New Zealander");
        Director sianHeder = new Director(44, "Sian Heder", LocalDate.of(1977, 6, 23), "American");
        Director danielKwan = new Director(45, "Daniel Kwan", LocalDate.of(1988, 2, 10), "American");
        Director danielScheinert = new Director(46, "Daniel Scheinert", LocalDate.of(1987, 6, 7), "American");
        Director mattReeves = new Director(47, "Matt Reeves", LocalDate.of(1966, 4, 27), "American");
        Director josephKosinski = new Director(48, "Joseph Kosinski", LocalDate.of(1974, 5, 3), "American");
        Director jamesCameron = new Director(49, "James Cameron", LocalDate.of(1954, 8, 16), "Canadian");
        Director robertZemeckis = new Director(50, "Robert Zemeckis", LocalDate.of(1952, 5, 14), "U.S.");
        Director lanaWachowski = new Director(51, "Lana Wachowski", LocalDate.of(1965, 6, 21), "U.S.");
        Director lillyWachowski = new Director(52, "Lilly Wachowski", LocalDate.of(1967, 12, 29), "U.S.");
        Director damienChazelle = new Director(54, "Damien Chazelle", LocalDate.of(1985, 1, 19), "U.S.");
        Director georgeMiller = new Director(55, "George Miller", LocalDate.of(1945, 3, 3), "Australian");
        Director adamMcKay = new Director(56, "Adam McKay", LocalDate.of(1968, 4, 17), "U.S");
        Director alexGarland = new Director(57, "Alex Garland", LocalDate.of(1970, 5, 26), "British");
        Director spikeJonze = new Director(58, "Spike Jonze", LocalDate.of(1969, 10, 22), "American");
        Director yorgosLanthimos = new Director(59, "Yorgos Lanthimos", LocalDate.of(1973, 9, 27), "Greek");
        Director danGilroy = new Director(60, "Dan Gilroy", LocalDate.of(1959, 6, 24), "American");
        Director jenniferKent = new Director(61, "Jennifer Kent", LocalDate.of(1966, 3, 10), "Australian");
        Director jordanPeele = new Director(62, "Jordan Peele", LocalDate.of(1979, 2, 21), "American");
        Director johnKrasinski = new Director(63, "John Krasinski", LocalDate.of(1979, 10, 20), "American");
        Director robertEggers = new Director(64, "Robert Eggers", LocalDate.of(1983, 7, 7), "American");
        Director dannyBoyle = new Director(65, "Danny Boyle", LocalDate.of(1956, 10, 20), "British");

        return Set.of(
                christopherNolan, francisFordCoppola, quentinTarantino, martinScorsese, toddPhillips,
                jonathanDemme, alfredHitchcock, stanleyKubrick, davidFrankel, chrisColumbus, alfonsoCuaron,
                mikeNewell, davidYates, robertoBenigni, peterWeir, frankDarabont, romanPolanski, davidFincher,
                ridleyScott, peterJackson, tateTaylor, angLee, steveMcQueen, jamesMarsh, mortenTyldum, joshBoone,
                benStiller, bazLuhrmann, wesAnderson, alejandroGonzalezInarritu, tomMcCarthy, tomHooper,
                guillermoDelToro, martinMcDonagh, lucaGuadagnino, bradleyCooper, bryanSinger, samMendes, bongJoonHo,
                gretaGerwig, rianJohnson, chloeZhao, denisVilleneuve, janeCampion, sianHeder, danielKwan,
                danielScheinert, mattReeves, josephKosinski, jamesCameron, robertZemeckis, lanaWachowski,
                lillyWachowski, damienChazelle, georgeMiller, adamMcKay, alexGarland, spikeJonze, yorgosLanthimos,
                danGilroy, jenniferKent, jordanPeele, johnKrasinski, robertEggers, dannyBoyle
        );
    }

    private void addDefaultDirectors(Set<Director> dir) {
        directors.addAll(dir);
    }

    private Set<Actor> createDefaultActors() {
        Actor leonardoDiCaprio = new Actor(0, "Leonardo DiCaprio", LocalDate.of(1974, 11, 11), "U.S.");
        Actor josephGordonLevitt = new Actor(1, "Joseph Gordon-Levitt", LocalDate.of(1981, 2, 17), "U.S.");
        Actor kenWatanabe = new Actor(2, "Ken Watanabe", LocalDate.of(1959, 10, 21), "Japanese");
        Actor marlonBrando = new Actor(3, "Marlon Brando", LocalDate.of(1924, 4, 3), "U.S.");
        Actor alPacino = new Actor(4, "Al Pacino", LocalDate.of(1940, 4, 25), "U.S.");
        Actor jamesCaan = new Actor(5, "James Caan", LocalDate.of(1940, 3, 26), "U.S.");
        Actor robertDuvall = new Actor(6, "Robert Duvall", LocalDate.of(1931, 1, 5), "U.S.");
        Actor johnTravolta = new Actor(7, "John Travolta", LocalDate.of(1954, 2, 18), "U.S.");
        Actor samuelLJackson = new Actor(8, "Samuel L. Jackson", LocalDate.of(1948, 12, 21), "U.S.");
        Actor umaThurman = new Actor(9, "Uma Thurman", LocalDate.of(1970, 4, 29), "U.S.");
        Actor bruceWillis = new Actor(10, "Bruce Willis", LocalDate.of(1955, 3, 19), "German");
        Actor joaquinPhoenix = new Actor(11, "Joaquin Phoenix", LocalDate.of(1974, 10, 28), "U.S.");
        Actor robertDeNiro = new Actor(12, "Robert De Niro", LocalDate.of(1943, 8, 17), "U.S.");
        Actor zazieBeetz = new Actor(13, "Zazie Beetz", LocalDate.of(1991, 5, 25), "U.S.");
        Actor jamieFoxx = new Actor(14, "Jamie Foxx", LocalDate.of(1967, 12, 13), "U.S.");
        Actor christophWaltz = new Actor(15, "Christoph Waltz", LocalDate.of(1956, 10, 4), "Austrian");
        Actor kerryWashington = new Actor(16, "Kerry Washington", LocalDate.of(1977, 1, 31), "U.S.");
        Actor waltonGoggins = new Actor(17, "Walton Goggins", LocalDate.of(1971, 11, 10), "U.S.");
        Actor jodieFoster = new Actor(18, "Jodie Foster", LocalDate.of(1962, 11, 19), "U.S.");
        Actor cybillShepherd = new Actor(19, "Cybill Shepherd", LocalDate.of(1950, 2, 18), "U.S.");
        Actor harveyKeitel = new Actor(20, "Harvey Keitel", LocalDate.of(1939, 5, 13), "U.S.");
        Actor anthonyHopkins = new Actor(21, "Anthony Hopkins", LocalDate.of(1937, 12, 31), "British");
        Actor scottGlenn = new Actor(22, "Scott Glenn", LocalDate.of(1939, 1, 26), "U.S.");
        Actor tedLevine = new Actor(23, "Ted Levine", LocalDate.of(1957, 5, 29), "U.S.");
        Actor rayLiotta = new Actor(24, "Ray Liotta", LocalDate.of(1954, 12, 18), "U.S.");
        Actor joePesci = new Actor(25, "Joe Pesci", LocalDate.of(1943, 2, 9), "U.S.");
        Actor lorraineBracco = new Actor(26, "Lorraine Bracco", LocalDate.of(1954, 10, 2), "U.S.");
        Actor matthewMcConaughey = new Actor(27, "Matthew McConaughey", LocalDate.of(1969, 11, 4), "U.S.");
        Actor anneHathaway = new Actor(28, "Anne Hathaway", LocalDate.of(1982, 11, 12), "U.S.");
        Actor michaelCaine = new Actor(29, "Michael Caine", LocalDate.of(1933, 3, 14), "British");
        Actor lilyGladstone = new Actor(30, "Lily Gladstone", LocalDate.of(1986, 8, 2), "U.S.");
        Actor anthonyPerkins = new Actor(31, "Anthony Perkins", LocalDate.of(1932, 4, 4), "U.S.");
        Actor janetLeigh = new Actor(32, "Janet Leigh", LocalDate.of(1927, 7, 6), "U.S.");
        Actor veraMiles = new Actor(33, "Vera Miles", LocalDate.of(1929, 8, 23), "U.S.");
        Actor johnGavin = new Actor(34, "John Gavin", LocalDate.of(1931, 4, 8), "U.S.");
        Actor tomCruise = new Actor(35, "Tom Cruise", LocalDate.of(1962, 7, 3), "U.S.");
        Actor nicoleKidman = new Actor(36, "Nicole Kidman", LocalDate.of(1967, 6, 20), "U.S.");
        Actor sydneyPollack = new Actor(37, "Sydney Pollack", LocalDate.of(1934, 7, 1), "U.S.");
        Actor merylStreep = new Actor(38, "Meryl Streep", LocalDate.of(1949, 6, 22), "U.S.");
        Actor emilyBlunt = new Actor(39, "Emily Blunt", LocalDate.of(1983, 2, 23), "British");
        Actor stanleyTucci = new Actor(40, "Stanley Tucci", LocalDate.of(1960, 11, 11), "U.S.");
        Actor timRobbins = new Actor(41, "Tim Robbins", LocalDate.of(1958, 10, 16), "U.S.");
        Actor morganFreeman = new Actor(42, "Morgan Freeman", LocalDate.of(1937, 6, 1), "U.S.");
        Actor christianBale = new Actor(43, "Christian Bale", LocalDate.of(1974, 1, 30), "British");
        Actor heathLedger = new Actor(44, "Heath Ledger", LocalDate.of(1979, 4, 4), "Australian");
        Actor aaronEckhart = new Actor(45, "Aaron Eckhart", LocalDate.of(1968, 3, 12), "U.S.");
        Actor tomHanks = new Actor(46, "Tom Hanks", LocalDate.of(1956, 7, 9), "U.S.");
        Actor robinWright = new Actor(47, "Robin Wright", LocalDate.of(1966, 4, 8), "U.S.");
        Actor garySinise = new Actor(48, "Gary Sinise", LocalDate.of(1955, 3, 17), "U.S.");
        Actor keanuReeves = new Actor(49, "Keanu Reeves", LocalDate.of(1964, 9, 2), "Canadian");
        Actor laurenceFishburne = new Actor(50, "Laurence Fishburne", LocalDate.of(1961, 7, 30), "U.S.");
        Actor carrieAnneMoss = new Actor(51, "Carrie-Anne Moss", LocalDate.of(1967, 8, 21), "Canadian");
        Actor bradPitt = new Actor(52, "Brad Pitt", LocalDate.of(1963, 12, 18), "U.S.");
        Actor edwardNorton = new Actor(53, "Edward Norton", LocalDate.of(1969, 8, 18), "U.S.");
        Actor helenaBonhamCarter = new Actor(54, "Helena Bonham Carter", LocalDate.of(1966, 5, 26), "British");
        Actor russellCrowe = new Actor(55, "Russell Crowe", LocalDate.of(1964, 4, 7), "New Zealander");
        Actor connieNielsen = new Actor(56, "Connie Nielsen", LocalDate.of(1965, 7, 3), "Danish");
        Actor elijahWood = new Actor(57, "Elijah Wood", LocalDate.of(1981, 1, 28), "U.S.");
        Actor ianMcKellen = new Actor(58, "Ian McKellen", LocalDate.of(1939, 5, 25), "British");
        Actor viggoMortensen = new Actor(59, "Viggo Mortensen", LocalDate.of(1958, 10, 20), "U.S.");
        Actor jesseEisenberg = new Actor(60, "Jesse Eisenberg", LocalDate.of(1983, 10, 5), "U.S.");
        Actor andrewGarfield = new Actor(61, "Andrew Garfield", LocalDate.of(1983, 8, 20), "British");
        Actor justinTimberlake = new Actor(62, "Justin Timberlake", LocalDate.of(1981, 1, 31), "U.S.");
        Actor melanieLaurent = new Actor(63, "Mélanie Laurent", LocalDate.of(1983, 2, 21), "French");
        Actor mattDamon = new Actor(64, "Matt Damon", LocalDate.of(1970, 10, 8), "U.S.");
        Actor jackNicholson = new Actor(65, "Jack Nicholson", LocalDate.of(1937, 4, 22), "U.S.");
        Actor tomHardy = new Actor(66, "Tom Hardy", LocalDate.of(1977, 9, 15), "British");
        Actor willPoulter = new Actor(67, "Will Poulter", LocalDate.of(1993, 1, 28), "British");
        Actor ralphFiennes = new Actor(68, "Ralph Fiennes", LocalDate.of(1962, 12, 22), "British");
        Actor fMurrayAbraham = new Actor(69, "F. Murray Abraham", LocalDate.of(1939, 10, 24), "U.S.");
        Actor mathieuAmalric = new Actor(70, "Mathieu Amalric", LocalDate.of(1965, 10, 25), "French");
        Actor ryanGosling = new Actor(71, "Ryan Gosling", LocalDate.of(1980, 11, 12), "Canadian");
        Actor emmaStone = new Actor(72, "Emma Stone", LocalDate.of(1988, 11, 6), "U.S.");
        Actor johnLegend = new Actor(73, "John Legend", LocalDate.of(1978, 12, 28), "U.S.");
        Actor sallyHawkins = new Actor(74, "Sally Hawkins", LocalDate.of(1976, 4, 27), "British");
        Actor michaelShannon = new Actor(75, "Michael Shannon", LocalDate.of(1974, 8, 7), "U.S.");
        Actor richardJenkins = new Actor(76, "Richard Jenkins", LocalDate.of(1947, 5, 4), "U.S.");
        Actor songKangHo = new Actor(77, "Song Kang-ho", LocalDate.of(1967, 1, 17), "South Korean");
        Actor leeSunKyun = new Actor(78, "Lee Sun-kyun", LocalDate.of(1975, 3, 2), "South Korean");
        Actor choYeoJeong = new Actor(79, "Cho Yeo-jeong", LocalDate.of(1981, 2, 10), "South Korean");
        Actor harrisonFord = new Actor(80, "Harrison Ford", LocalDate.of(1942, 7, 13), "U.S.");
        Actor anaDeArmas = new Actor(81, "Ana de Armas", LocalDate.of(1988, 4, 30), "Cuban");
        Actor charlizeTheron = new Actor(82, "Charlize Theron", LocalDate.of(1975, 8, 7), "South African");
        Actor nicholasHoult = new Actor(83, "Nicholas Hoult", LocalDate.of(1989, 12, 7), "British");
        Actor jonahHill = new Actor(84, "Jonah Hill", LocalDate.of(1983, 12, 20), "U.S.");
        Actor margotRobbie = new Actor(85, "Margot Robbie", LocalDate.of(1990, 7, 2), "Australian");
        Actor fionnWhitehead = new Actor(86, "Fionn Whitehead", LocalDate.of(1997, 7, 18), "British");
        Actor harryStyles = new Actor(87, "Harry Styles", LocalDate.of(1994, 2, 1), "British");
        Actor robertPattinson = new Actor(88, "Robert Pattinson", LocalDate.of(1986, 5, 13), "British");
        Actor willemDafoe = new Actor(89, "Willem Dafoe", LocalDate.of(1955, 7, 22), "U.S.");
        Actor benAffleck = new Actor(90, "Ben Affleck", LocalDate.of(1972, 8, 15), "U.S.");
        Actor rosamundPike = new Actor(91, "Rosamund Pike", LocalDate.of(1979, 1, 27), "British");
        Actor neilPatrickHarris = new Actor(92, "Neil Patrick Harris", LocalDate.of(1973, 6, 15), "U.S.");
        Actor markRuffalo = new Actor(93, "Mark Ruffalo", LocalDate.of(1967, 11, 22), "U.S.");
        Actor rachelMcAdams = new Actor(94, "Rachel McAdams", LocalDate.of(1978, 11, 17), "Canadian");
        Actor eddieRedmayne = new Actor(95, "Eddie Redmayne", LocalDate.of(1982, 1, 6), "British");
        Actor felicityJones = new Actor(96, "Felicity Jones", LocalDate.of(1983, 10, 17), "British");
        Actor benWhishaw = new Actor(97, "Ben Whishaw", LocalDate.of(1980, 10, 14), "British");
        Actor shaileneWoodley = new Actor(98, "Shailene Woodley", LocalDate.of(1991, 11, 15), "U.S.");
        Actor anselElgort = new Actor(99, "Ansel Elgort", LocalDate.of(1994, 3, 14), "U.S.");
        Actor milesTeller = new Actor(100, "Miles Teller", LocalDate.of(1987, 2, 20), "U.S.");
        Actor jkSimmons = new Actor(101, "J.K. Simmons", LocalDate.of(1955, 1, 9), "U.S.");
        Actor jessicaChastain = new Actor(102, "Jessica Chastain", LocalDate.of(1977, 3, 24), "American");
        Actor kristenWiig = new Actor(103, "Kristen Wiig", LocalDate.of(1973, 8, 22), "American");
        Actor kurtRussell = new Actor(104, "Kurt Russell", LocalDate.of(1951, 3, 17), "American");
        Actor jenniferJasonLeigh = new Actor(105, "Jennifer Jason Leigh", LocalDate.of(1962, 2, 5), "American");
        Actor amyAdams = new Actor(106, "Amy Adams", LocalDate.of(1974, 8, 20), "American");
        Actor jeremyRenner = new Actor(107, "Jeremy Renner", LocalDate.of(1971, 1, 7), "American");
        Actor forestWhitaker = new Actor(108, "Forest Whitaker", LocalDate.of(1961, 7, 15), "American");
        Actor aliciaVikander = new Actor(109, "Alicia Vikander", LocalDate.of(1988, 10, 3), "Swedish");
        Actor domhnallGleeson = new Actor(110, "Domhnall Gleeson", LocalDate.of(1983, 5, 12), "Irish");
        Actor oscarIsaac = new Actor(111, "Oscar Isaac", LocalDate.of(1979, 3, 9), "Guatemalan-American");
        Actor scarlettJohansson = new Actor(112, "Scarlett Johansson", LocalDate.of(1984, 11, 22), "American");
        Actor colinFarrell = new Actor(113, "Colin Farrell", LocalDate.of(1976, 5, 31), "Irish");
        Actor rachelWeisz = new Actor(114, "Rachel Weisz", LocalDate.of(1970, 3, 7), "British");
        Actor jessicaBarden = new Actor(115, "Jessica Barden", LocalDate.of(1992, 7, 21), "British");
        Actor jakeGyllenhaal = new Actor(116, "Jake Gyllenhaal", LocalDate.of(1980, 12, 19), "American");
        Actor reneRusso = new Actor(117, "Rene Russo", LocalDate.of(1954, 2, 17), "American");
        Actor billPaxton = new Actor(118, "Bill Paxton", LocalDate.of(1955, 5, 17), "American");
        Actor essieDavis = new Actor(119, "Essie Davis", LocalDate.of(1970, 1, 1), "Australian");
        Actor noahWiseman = new Actor(120, "Noah Wiseman", LocalDate.of(2004, 1, 1), "Australian");
        Actor danielKaluuya = new Actor(121, "Daniel Kaluuya", LocalDate.of(1989, 2, 24), "British");
        Actor allisonWilliams = new Actor(122, "Allison Williams", LocalDate.of(1988, 4, 13), "American");
        Actor bradleyWhitford = new Actor(123, "Bradley Whitford", LocalDate.of(1959, 10, 10), "American");
        Actor millicentSimmonds = new Actor(124, "Millicent Simmonds", LocalDate.of(2003, 1, 1), "American");
        Actor danielRadcliffe = new Actor(125, "Daniel Radcliffe", LocalDate.of(1989, 7, 23), "British");
        Actor emmaWatson = new Actor(126, "Emma Watson", LocalDate.of(1990, 4, 15), "British");
        Actor rupertGrint = new Actor(127, "Rupert Grint", LocalDate.of(1988, 8, 24), "British");
        Actor nicolettaBraschi = new Actor(128, "Nicoletta Braschi", LocalDate.of(1960, 4, 19), "Italian");
        Actor giorgioCantarini = new Actor(129, "Giorgio Cantarini", LocalDate.of(1992, 4, 12), "Italian");
        Actor jimCarrey = new Actor(130, "Jim Carrey", LocalDate.of(1962, 1, 17), "Canadian");
        Actor lauraLinney = new Actor(131, "Laura Linney", LocalDate.of(1964, 2, 5), "American");
        Actor edHarris = new Actor(132, "Ed Harris", LocalDate.of(1950, 11, 28), "American");
        Actor michaelClarkeDuncan = new Actor(133, "Michael Clarke Duncan", LocalDate.of(1957, 12, 10), "American");
        Actor davidMorse = new Actor(134, "David Morse", LocalDate.of(1953, 10, 11), "American");
        Actor adrienBrody = new Actor(135, "Adrien Brody", LocalDate.of(1973, 4, 14), "American");
        Actor thomasKretschmann = new Actor(136, "Thomas Kretschmann", LocalDate.of(1962, 9, 8), "German");
        Actor frankFinlay = new Actor(137, "Frank Finlay", LocalDate.of(1926, 8, 6), "British");
        Actor hughJackman = new Actor(138, "Hugh Jackman", LocalDate.of(1968, 10, 12), "Australian");
        Actor cateBlanchett = new Actor(139, "Cate Blanchett", LocalDate.of(1969, 5, 14), "Australian");
        Actor tildaSwinton = new Actor(140, "Tilda Swinton", LocalDate.of(1960, 11, 5), "British");
        Actor devPatel = new Actor(141, "Dev Patel", LocalDate.of(1990, 4, 23), "British");
        Actor freidaPinto = new Actor(142, "Freida Pinto", LocalDate.of(1984, 10, 18), "Indian");
        Actor anilKapoor = new Actor(143, "Anil Kapoor", LocalDate.of(1956, 12, 24), "Indian");
        Actor colinFirth = new Actor(144, "Colin Firth", LocalDate.of(1960, 9, 10), "British");
        Actor geoffreyRush = new Actor(145, "Geoffrey Rush", LocalDate.of(1951, 7, 6), "Australian");
        Actor violaDavis = new Actor(146, "Viola Davis", LocalDate.of(1965, 8, 11), "American");
        Actor octaviaSpencer = new Actor(147, "Octavia Spencer", LocalDate.of(1970, 5, 25), "American");
        Actor surajSharma = new Actor(148, "Suraj Sharma", LocalDate.of(1993, 3, 21), "Indian");
        Actor irrfanKhan = new Actor(149, "Irrfan Khan", LocalDate.of(1967, 1, 7), "Indian");
        Actor adilHussain = new Actor(150, "Adil Hussain", LocalDate.of(1963, 10, 5), "Indian");
        Actor chiwetelEjiofor = new Actor(151, "Chiwetel Ejiofor", LocalDate.of(1977, 7, 10), "British");
        Actor michaelFassbender = new Actor(152, "Michael Fassbender", LocalDate.of(1977, 4, 2), "German-Irish");
        Actor lupitaNyongo = new Actor(153, "Lupita Nyong'o", LocalDate.of(1983, 3, 1), "Mexican-Kenyan");
        Actor tomPrior = new Actor(154, "Tom Prior", LocalDate.of(1990, 1, 1), "British");
        Actor benedictCumberbatch = new Actor(155, "Benedict Cumberbatch", LocalDate.of(1976, 7, 19), "British");
        Actor keiraKnightley = new Actor(156, "Keira Knightley", LocalDate.of(1985, 3, 26), "British");
        Actor matthewGoode = new Actor(157, "Matthew Goode", LocalDate.of(1978, 4, 3), "British");
        Actor natWolff = new Actor(158, "Nat Wolff", LocalDate.of(1994, 12, 17), "American");
        Actor shirleyMacLaine = new Actor(159, "Shirley MacLaine", LocalDate.of(1934, 4, 24), "American");
        Actor careyMulligan = new Actor(160, "Carey Mulligan", LocalDate.of(1985, 5, 28), "British");
        Actor tobeyMaguire = new Actor(161, "Tobey Maguire", LocalDate.of(1975, 6, 27), "American");
        Actor francesMcDormand = new Actor(162, "Frances McDormand", LocalDate.of(1957, 6, 23), "American");
        Actor woodyHarrelson = new Actor(163, "Woody Harrelson", LocalDate.of(1961, 7, 23), "American");
        Actor samRockwell = new Actor(164, "Sam Rockwell", LocalDate.of(1968, 11, 5), "American");
        Actor timotheeChalamet = new Actor(165, "Timothée Chalamet", LocalDate.of(1995, 12, 27), "American");
        Actor armieHammer = new Actor(166, "Armie Hammer", LocalDate.of(1986, 8, 28), "American");
        Actor michaelStuhlbarg = new Actor(167, "Michael Stuhlbarg", LocalDate.of(1968, 7, 5), "American");
        Actor ladyGaga = new Actor(168, "Lady Gaga", LocalDate.of(1986, 3, 28), "American");
        Actor samElliott = new Actor(169, "Sam Elliott", LocalDate.of(1944, 8, 9), "American");
        Actor ramiMalek = new Actor(170, "Rami Malek", LocalDate.of(1981, 5, 24), "American");
        Actor lucyBoynton = new Actor(171, "Lucy Boynton", LocalDate.of(1994, 1, 17), "British");
        Actor gwilymLee = new Actor(172, "Gwilym Lee", LocalDate.of(1983, 11, 24), "British");
        Actor georgeMacKay = new Actor(173, "George MacKay", LocalDate.of(1992, 3, 13), "British");
        Actor deanCharlesChapman = new Actor(174, "Dean-Charles Chapman", LocalDate.of(1997, 9, 7), "British");
        Actor markStrong = new Actor(175, "Mark Strong", LocalDate.of(1963, 8, 5), "British");
        Actor saoirseRonan = new Actor(176, "Saoirse Ronan", LocalDate.of(1994, 4, 12), "Irish");
        Actor florencePugh = new Actor(177, "Florence Pugh", LocalDate.of(1996, 1, 3), "British");
        Actor danielCraig = new Actor(178, "Daniel Craig", LocalDate.of(1968, 3, 2), "British");
        Actor chrisEvans = new Actor(179, "Chris Evans", LocalDate.of(1981, 6, 13), "American");
        Actor johnDavidWashington = new Actor(180, "John David Washington", LocalDate.of(1984, 7, 28), "American");
        Actor elizabethDebicki = new Actor(181, "Elizabeth Debicki", LocalDate.of(1990, 8, 24), "Australian");
        Actor davidStrathairn = new Actor(182, "David Strathairn", LocalDate.of(1949, 1, 26), "American");
        Actor lindaMay = new Actor(183, "Linda May", LocalDate.of(1958, 1, 1), "American");
        Actor rebeccaFerguson = new Actor(184, "Rebecca Ferguson", LocalDate.of(1983, 10, 19), "Swedish");
        Actor kirstenDunst = new Actor(185, "Kirsten Dunst", LocalDate.of(1982, 4, 30), "American");
        Actor jessePlemons = new Actor(186, "Jesse Plemons", LocalDate.of(1988, 4, 2), "American");
        Actor emiliaJones = new Actor(187, "Emilia Jones", LocalDate.of(2002, 2, 23), "British");
        Actor marleeMatlin = new Actor(188, "Marlee Matlin", LocalDate.of(1965, 8, 24), "American");
        Actor troyKotsur = new Actor(189, "Troy Kotsur", LocalDate.of(1968, 7, 24), "American");
        Actor michelleYeoh = new Actor(190, "Michelle Yeoh", LocalDate.of(1962, 8, 6), "Malaysian");
        Actor stephanieHsu = new Actor(191, "Stephanie Hsu", LocalDate.of(1990, 11, 25), "American");
        Actor keHuyQuan = new Actor(192, "Ke Huy Quan", LocalDate.of(1971, 8, 20), "Vietnamese-American");
        Actor zoeKravitz = new Actor(193, "Zoë Kravitz", LocalDate.of(1988, 12, 1), "American");
        Actor paulDano = new Actor(194, "Paul Dano", LocalDate.of(1984, 6, 19), "American");
        Actor jenniferConnelly = new Actor(195, "Jennifer Connelly", LocalDate.of(1970, 12, 12), "American");
        Actor austinButler = new Actor(196, "Austin Butler", LocalDate.of(1991, 8, 17), "American");
        Actor oliviaDeJonge = new Actor(197, "Olivia DeJonge", LocalDate.of(1998, 4, 30), "Australian");
        Actor samWorthington = new Actor(198, "Sam Worthington", LocalDate.of(1976, 8, 2), "Australian");
        Actor zoeSaldana = new Actor(199, "Zoe Saldana", LocalDate.of(1978, 6, 19), "American");
        Actor sigourneyWeaver = new Actor(200, "Sigourney Weaver", LocalDate.of(1949, 10, 8), "American");
        Actor steveCarell = new Actor(201, "Steve Carell", LocalDate.of(1962, 8, 16), "American");
        Actor michaelKeaton = new Actor(202, "Michael Keaton", LocalDate.of(1951, 9, 5), "U.S.");
        Actor sandraBullock = new Actor(203, "Sandra Bullock", LocalDate.of(1964, 7, 26), "U.S.");
        Actor georgeClooney = new Actor(204, "George Clooney", LocalDate.of(1961, 5, 6), "U.S.");
        Actor johnKrasinski = new Actor(205, "John Krasinski", LocalDate.of(1979, 10, 20), "U.S.");
        Actor robertoBenigni = new Actor(206, "Roberto Benigni", LocalDate.of(1952, 10, 27), "Italian");
        Actor benStiller = new Actor(207, "Ben Stiller", LocalDate.of(1965, 11, 30), "U.S.");
        Actor bradleyCooper = new Actor(208, "Bradley Cooper", LocalDate.of(1975, 1, 5), "U.S.");

        return Set.of(leonardoDiCaprio, josephGordonLevitt, kenWatanabe, marlonBrando, alPacino, jamesCaan, robertDuvall, johnTravolta, samuelLJackson, umaThurman, bruceWillis, joaquinPhoenix, robertDeNiro,
                zazieBeetz, jamieFoxx, christophWaltz, kerryWashington, waltonGoggins, jodieFoster, cybillShepherd, harveyKeitel, anthonyHopkins, scottGlenn, tedLevine, rayLiotta, joePesci,
                lorraineBracco, matthewMcConaughey, anneHathaway, michaelCaine, lilyGladstone, anthonyPerkins, janetLeigh, veraMiles, johnGavin, tomCruise, nicoleKidman, sydneyPollack, merylStreep,
                emilyBlunt, stanleyTucci, timRobbins, morganFreeman, christianBale, heathLedger, aaronEckhart, tomHanks, robinWright, garySinise, keanuReeves, laurenceFishburne, carrieAnneMoss,
                bradPitt, edwardNorton, helenaBonhamCarter, russellCrowe, connieNielsen, elijahWood, ianMcKellen, viggoMortensen, jesseEisenberg, andrewGarfield, justinTimberlake, melanieLaurent,
                mattDamon, jackNicholson, tomHardy, willPoulter, ralphFiennes, fMurrayAbraham, mathieuAmalric, ryanGosling, emmaStone, johnLegend, sallyHawkins, michaelShannon, richardJenkins,
                songKangHo, leeSunKyun, choYeoJeong, harrisonFord, anaDeArmas, charlizeTheron, nicholasHoult, jonahHill, margotRobbie, fionnWhitehead, harryStyles, robertPattinson, willemDafoe,
                benAffleck, rosamundPike, neilPatrickHarris, markRuffalo, rachelMcAdams, eddieRedmayne, felicityJones, benWhishaw, shaileneWoodley, anselElgort, milesTeller, jkSimmons,
                jessicaChastain, kristenWiig, kurtRussell, jenniferJasonLeigh, amyAdams, jeremyRenner, forestWhitaker, aliciaVikander, domhnallGleeson, oscarIsaac, scarlettJohansson, colinFarrell,
                rachelWeisz, jessicaBarden, jakeGyllenhaal, reneRusso, billPaxton, essieDavis, noahWiseman, danielKaluuya, allisonWilliams, bradleyWhitford, millicentSimmonds, danielRadcliffe, emmaWatson,
                rupertGrint, nicolettaBraschi, giorgioCantarini, jimCarrey, lauraLinney, edHarris, michaelClarkeDuncan, davidMorse, adrienBrody, thomasKretschmann, frankFinlay, hughJackman, cateBlanchett,
                tildaSwinton, devPatel, freidaPinto, anilKapoor, colinFirth, geoffreyRush, violaDavis, octaviaSpencer, surajSharma, irrfanKhan, adilHussain, chiwetelEjiofor, michaelFassbender, lupitaNyongo,
                tomPrior, benedictCumberbatch, keiraKnightley, matthewGoode, natWolff, shirleyMacLaine, careyMulligan, tobeyMaguire, francesMcDormand, woodyHarrelson, samRockwell, timotheeChalamet, armieHammer,
                michaelStuhlbarg, ladyGaga, samElliott, ramiMalek, lucyBoynton, gwilymLee, georgeMacKay, deanCharlesChapman, markStrong, saoirseRonan, florencePugh, danielCraig, chrisEvans, johnDavidWashington,
                elizabethDebicki, davidStrathairn, lindaMay, rebeccaFerguson, kirstenDunst, jessePlemons, emiliaJones, marleeMatlin, troyKotsur, michelleYeoh, stephanieHsu, keHuyQuan, zoeKravitz, paulDano,
                jenniferConnelly, austinButler, oliviaDeJonge, samWorthington, zoeSaldana, sigourneyWeaver, steveCarell, michaelKeaton, sandraBullock, georgeClooney, johnKrasinski, robertoBenigni, benStiller,
                bradleyCooper
        );
    }

    private void addDefaultActors(Set<Actor> act) {
        actors.addAll(act);
    }

    public Director findDirectorByName(String name) {
        return directors.stream()
                .filter(director -> director.getName().equalsIgnoreCase(name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Director no existent: " + name));
    }

    public Actor findActorByName(String name) {
        return actors.stream()
                .filter(actor -> actor.getName().equalsIgnoreCase(name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Actor no existent: " + name));
    }


    private void addDefaultMovies() {
        movies.add(new Movie(
                1, "Inception", Set.of(findDirectorByName("Christopher Nolan")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Joseph Gordon-Levitt"), findActorByName("Ken Watanabe")),
                Set.of("Action", "Adventure", "Science Fiction"), Year.of(2010)));

        movies.add(new Movie(
                2, "The Godfather", Set.of(findDirectorByName("Francis Ford Coppola")),
                Set.of(findActorByName("Marlon Brando"), findActorByName("Al Pacino"), findActorByName("James Caan"), findActorByName("Robert Duvall")),
                Set.of("Crime", "Drama"), Year.of(1972)));

        movies.add(new Movie(
                3, "Pulp Fiction", Set.of(findDirectorByName("Quentin Tarantino")),
                Set.of(findActorByName("John Travolta"), findActorByName("Samuel L. Jackson"), findActorByName("Uma Thurman"), findActorByName("Bruce Willis")),
                Set.of("Crime", "Thriller"), Year.of(1994)));

        movies.add(new Movie(
                4, "Joker", Set.of(findDirectorByName("Todd Phillips")),
                Set.of(findActorByName("Joaquin Phoenix"), findActorByName("Robert De Niro"), findActorByName("Zazie Beetz")),
                Set.of("Crime", "Drama", "Thriller"), Year.of(2019)));

        movies.add(new Movie(
                5, "Django Unchained", Set.of(findDirectorByName("Quentin Tarantino")),
                Set.of(findActorByName("Jamie Foxx"), findActorByName("Christoph Waltz"), findActorByName("Leonardo DiCaprio"), findActorByName("Kerry Washington"), findActorByName("Samuel L. Jackson"), findActorByName("Walton Goggins")),
                Set.of("Western"), Year.of(2012)));

        movies.add(new Movie(
                6, "Taxi Driver", Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Robert De Niro"), findActorByName("Jodie Foster"), findActorByName("Cybill Shepherd"), findActorByName("Harvey Keitel")),
                Set.of("Drama", "Crime"), Year.of(1976)));

        movies.add(new Movie(
                7, "The Silence of the Lambs", Set.of(findDirectorByName("Jonathan Demme")),
                Set.of(findActorByName("Jodie Foster"), findActorByName("Anthony Hopkins"), findActorByName("Scott Glenn"), findActorByName("Ted Levine")),
                Set.of("Horror", "Crime", "Thriller", "Drama"), Year.of(1991)));

        movies.add(new Movie(
                8, "GoodFellas", Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Robert De Niro"), findActorByName("Ray Liotta"), findActorByName("Joe Pesci"), findActorByName("Lorraine Bracco")),
                Set.of("Drama", "Crime"), Year.of(1990)));

        movies.add(new Movie(
                9, "Interstellar", Set.of(findDirectorByName("Christopher Nolan")),
                Set.of(findActorByName("Matthew McConaughey"), findActorByName("Anne Hathaway"), findActorByName("Michael Caine")),
                Set.of("Science Fiction", "Drama", "Adventure"), Year.of(2014)));

        movies.add(new Movie(
                10, "The Devil Wears Prada", Set.of(findDirectorByName("David Frankel")),
                Set.of(findActorByName("Meryl Streep"), findActorByName("Anne Hathaway"), findActorByName("Emily Blunt"), findActorByName("Stanley Tucci")),
                Set.of("Comedy", "Drama"), Year.of(2006)));

        movies.add(new Movie(
                11, "Killers of the Flower Moon", Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Robert De Niro"), findActorByName("Lily Gladstone")),
                Set.of("History", "Crime", "Drama"), Year.of(2023)));

        movies.add(new Movie(
                12, "Psycho", Set.of(findDirectorByName("Alfred Hitchcock")),
                Set.of(findActorByName("Anthony Perkins"), findActorByName("Janet Leigh"), findActorByName("Vera Miles"), findActorByName("John Gavin")),
                Set.of("Mystery", "Thriller", "Horror"), Year.of(1960)));

        movies.add(new Movie(
                13, "Eyes Wide Shut", Set.of(findDirectorByName("Stanley Kubrick")),
                Set.of(findActorByName("Tom Cruise"), findActorByName("Nicole Kidman"), findActorByName("Sydney Pollack")),
                Set.of("Thriller", "Drama", "Mystery"), Year.of(1999)));

        movies.add(new Movie(14, "The Shawshank Redemption", Set.of(findDirectorByName("Frank Darabont")),
                Set.of(findActorByName("Tim Robbins"), findActorByName("Morgan Freeman")),
                Set.of("Drama"), Year.of(1994)));

        movies.add(new Movie(15, "The Dark Knight", Set.of(findDirectorByName("Christopher Nolan")),
                Set.of(findActorByName("Christian Bale"), findActorByName("Heath Ledger"), findActorByName("Aaron Eckhart")),
                Set.of("Action", "Crime", "Drama"), Year.of(2008)));

        movies.add(new Movie(16, "Forrest Gump", Set.of(findDirectorByName("Robert Zemeckis")),
                Set.of(findActorByName("Tom Hanks"), findActorByName("Robin Wright"), findActorByName("Gary Sinise")),
                Set.of("Drama", "Romance"), Year.of(1994)));

        movies.add(new Movie(17, "The Matrix", Set.of(findDirectorByName("Lana Wachowski"), findDirectorByName("Lilly Wachowski")),
                Set.of(findActorByName("Keanu Reeves"), findActorByName("Laurence Fishburne"), findActorByName("Carrie-Anne Moss")),
                Set.of("Action", "Sci-Fi"), Year.of(1999)));

        movies.add(new Movie(18, "Fight Club", Set.of(findDirectorByName("David Fincher")),
                Set.of(findActorByName("Brad Pitt"), findActorByName("Edward Norton"), findActorByName("Helena Bonham Carter")),
                Set.of("Drama"), Year.of(1999)));

        movies.add(new Movie(19, "Gladiator", Set.of(findDirectorByName("Ridley Scott")),
                Set.of(findActorByName("Russell Crowe"), findActorByName("Joaquin Phoenix"), findActorByName("Connie Nielsen")),
                Set.of("Action", "Drama"), Year.of(2000)));

        movies.add(new Movie(20, "The Lord of the Rings: The Fellowship of the Ring", Set.of(findDirectorByName("Peter Jackson")),
                Set.of(findActorByName("Elijah Wood"), findActorByName("Ian McKellen"), findActorByName("Viggo Mortensen")),
                Set.of("Adventure", "Fantasy"), Year.of(2001)));

        movies.add(new Movie(21, "The Lord of the Rings: The Two Towers", Set.of(findDirectorByName("Peter Jackson")),
                Set.of(findActorByName("Elijah Wood"), findActorByName("Ian McKellen"), findActorByName("Viggo Mortensen")),
                Set.of("Adventure", "Fantasy"), Year.of(2002)));

        movies.add(new Movie(22, "The Lord of the Rings: The Return of the King", Set.of(findDirectorByName("Peter Jackson")),
                Set.of(findActorByName("Elijah Wood"), findActorByName("Ian McKellen"), findActorByName("Viggo Mortensen")),
                Set.of("Adventure", "Fantasy"), Year.of(2003)));

        movies.add(new Movie(23, "The Social Network", Set.of(findDirectorByName("David Fincher")),
                Set.of(findActorByName("Jesse Eisenberg"), findActorByName("Andrew Garfield"), findActorByName("Justin Timberlake")),
                Set.of("Biography", "Drama"), Year.of(2010)));

        movies.add(new Movie(24, "Inglourious Basterds", Set.of(findDirectorByName("Quentin Tarantino")),
                Set.of(findActorByName("Brad Pitt"), findActorByName("Christoph Waltz"), findActorByName("Mélanie Laurent")),
                Set.of("Adventure", "Drama", "War"), Year.of(2009)));

        movies.add(new Movie(25, "The Departed", Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Matt Damon"), findActorByName("Jack Nicholson")),
                Set.of("Crime", "Drama", "Thriller"), Year.of(2006)));

        movies.add(new Movie(26, "The Revenant", Set.of(findDirectorByName("Alejandro González Iñárritu")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Tom Hardy"), findActorByName("Will Poulter")),
                Set.of("Adventure", "Drama", "Thriller"), Year.of(2015)));

        movies.add(new Movie(27, "The Grand Budapest Hotel", Set.of(findDirectorByName("Wes Anderson")),
                Set.of(findActorByName("Ralph Fiennes"), findActorByName("F. Murray Abraham"), findActorByName("Mathieu Amalric")),
                Set.of("Adventure", "Comedy", "Drama"), Year.of(2014)));

        movies.add(new Movie(28, "La La Land", Set.of(findDirectorByName("Damien Chazelle")),
                Set.of(findActorByName("Ryan Gosling"), findActorByName("Emma Stone"), findActorByName("John Legend")),
                Set.of("Comedy", "Drama", "Musical"), Year.of(2016)));

        movies.add(new Movie(29, "The Shape of Water", Set.of(findDirectorByName("Guillermo del Toro")),
                Set.of(findActorByName("Sally Hawkins"), findActorByName("Michael Shannon"), findActorByName("Richard Jenkins")),
                Set.of("Adventure", "Drama", "Fantasy"), Year.of(2017)));

        movies.add(new Movie(30, "Parasite", Set.of(findDirectorByName("Bong Joon-ho")),
                Set.of(findActorByName("Song Kang-ho"), findActorByName("Lee Sun-kyun"), findActorByName("Cho Yeo-jeong")),
                Set.of("Comedy", "Drama", "Thriller"), Year.of(2019)));

        movies.add(new Movie(31, "Blade Runner 2049", Set.of(findDirectorByName("Denis Villeneuve")),
                Set.of(findActorByName("Ryan Gosling"), findActorByName("Harrison Ford"), findActorByName("Ana de Armas")),
                Set.of("Sci-Fi", "Thriller"), Year.of(2017)));

        movies.add(new Movie(32, "Mad Max: Fury Road", Set.of(findDirectorByName("George Miller")),
                Set.of(findActorByName("Tom Hardy"), findActorByName("Charlize Theron"), findActorByName("Nicholas Hoult")),
                Set.of("Action", "Adventure", "Sci-Fi"), Year.of(2015)));

        movies.add(new Movie(33, "The Wolf of Wall Street", Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Jonah Hill"), findActorByName("Margot Robbie")),
                Set.of("Biography", "Comedy", "Crime"), Year.of(2013)));

        movies.add(new Movie(34, "Dunkirk", Set.of(findDirectorByName("Christopher Nolan")),
                Set.of(findActorByName("Fionn Whitehead"), findActorByName("Tom Hardy"), findActorByName("Harry Styles")),
                Set.of("Action", "Drama", "History"), Year.of(2017)));

        movies.add(new Movie(35, "The Irishman", Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Robert De Niro"), findActorByName("Al Pacino"), findActorByName("Joe Pesci")),
                Set.of("Biography", "Crime", "Drama"), Year.of(2019)));

        movies.add(new Movie(36, "Whiplash", Set.of(findDirectorByName("Damien Chazelle")),
                Set.of(findActorByName("Miles Teller"), findActorByName("J.K. Simmons")),
                Set.of("Drama", "Music"), Year.of(2014)));

        movies.add(new Movie(37, "The Big Short", Set.of(findDirectorByName("Adam McKay")),
                Set.of(findActorByName("Christian Bale"), findActorByName("Steve Carell"), findActorByName("Ryan Gosling")),
                Set.of("Biography", "Comedy", "Drama"), Year.of(2015)));

        movies.add(new Movie(38, "Birdman", Set.of(findDirectorByName("Alejandro González Iñárritu")),
                Set.of(findActorByName("Michael Keaton"), findActorByName("Edward Norton"), findActorByName("Emma Stone")),
                Set.of("Comedy", "Drama"), Year.of(2014)));

        movies.add(new Movie(39, "The Martian", Set.of(findDirectorByName("Ridley Scott")),
                Set.of(findActorByName("Matt Damon"), findActorByName("Jessica Chastain"), findActorByName("Kristen Wiig")),
                Set.of("Adventure", "Drama", "Sci-Fi"), Year.of(2015)));

        movies.add(new Movie(40, "Gravity", Set.of(findDirectorByName("Alfonso Cuarón")),
                Set.of(findActorByName("Sandra Bullock"), findActorByName("George Clooney")),
                Set.of("Drama", "Sci-Fi", "Thriller"), Year.of(2013)));

        movies.add(new Movie(41, "The Hateful Eight", Set.of(findDirectorByName("Quentin Tarantino")),
                Set.of(findActorByName("Samuel L. Jackson"), findActorByName("Kurt Russell"), findActorByName("Jennifer Jason Leigh")),
                Set.of("Crime", "Drama", "Mystery"), Year.of(2015)));

        movies.add(new Movie(42, "Arrival", Set.of(findDirectorByName("Denis Villeneuve")),
                Set.of(findActorByName("Amy Adams"), findActorByName("Jeremy Renner"), findActorByName("Forest Whitaker")),
                Set.of("Drama", "Sci-Fi", "Thriller"), Year.of(2016)));

        movies.add(new Movie(43, "Ex Machina", Set.of(findDirectorByName("Alex Garland")),
                Set.of(findActorByName("Alicia Vikander"), findActorByName("Domhnall Gleeson"), findActorByName("Oscar Isaac")),
                Set.of("Drama", "Sci-Fi", "Thriller"), Year.of(2014)));

        movies.add(new Movie(44, "Her", Set.of(findDirectorByName("Spike Jonze")),
                Set.of(findActorByName("Joaquin Phoenix"), findActorByName("Scarlett Johansson"), findActorByName("Amy Adams")),
                Set.of("Drama", "Romance", "Sci-Fi"), Year.of(2013)));

        movies.add(new Movie(45, "The Lobster", Set.of(findDirectorByName("Yorgos Lanthimos")),
                Set.of(findActorByName("Colin Farrell"), findActorByName("Rachel Weisz"), findActorByName("Jessica Barden")),
                Set.of("Comedy", "Drama", "Romance"), Year.of(2015)));

        movies.add(new Movie(46, "Nightcrawler", Set.of(findDirectorByName("Dan Gilroy")),
                Set.of(findActorByName("Jake Gyllenhaal"), findActorByName("Rene Russo"), findActorByName("Bill Paxton")),
                Set.of("Crime", "Drama", "Thriller"), Year.of(2014)));

        movies.add(new Movie(47, "The Babadook", Set.of(findDirectorByName("Jennifer Kent")),
                Set.of(findActorByName("Essie Davis"), findActorByName("Noah Wiseman")),
                Set.of("Drama", "Horror"), Year.of(2014)));

        movies.add(new Movie(48, "Get Out", Set.of(findDirectorByName("Jordan Peele")),
                Set.of(findActorByName("Daniel Kaluuya"), findActorByName("Allison Williams"), findActorByName("Bradley Whitford")),
                Set.of("Horror", "Mystery", "Thriller"), Year.of(2017)));

        movies.add(new Movie(49, "A Quiet Place", Set.of(findDirectorByName("John Krasinski")),
                Set.of(findActorByName("Emily Blunt"), findActorByName("John Krasinski"), findActorByName("Millicent Simmonds")),
                Set.of("Drama", "Horror", "Sci-Fi"), Year.of(2018)));

        movies.add(new Movie(50, "The Lighthouse", Set.of(findDirectorByName("Robert Eggers")),
                Set.of(findActorByName("Robert Pattinson"), findActorByName("Willem Dafoe")),
                Set.of("Drama", "Fantasy", "Horror"), Year.of(2019)));

        movies.add(new Movie(51, "Harry Potter and the Philosopher's Stone", Set.of(findDirectorByName("Chris Columbus")),
                Set.of(findActorByName("Daniel Radcliffe"), findActorByName("Emma Watson"), findActorByName("Rupert Grint")),
                Set.of("Adventure", "Fantasy"), Year.of(2001)));

        movies.add(new Movie(52, "Harry Potter and the Chamber of Secrets", Set.of(findDirectorByName("Chris Columbus")),
                Set.of(findActorByName("Daniel Radcliffe"), findActorByName("Emma Watson"), findActorByName("Rupert Grint")),
                Set.of("Adventure", "Fantasy"), Year.of(2002)));

        movies.add(new Movie(53, "Harry Potter and the Prisoner of Azkaban", Set.of(findDirectorByName("Alfonso Cuarón")),
                Set.of(findActorByName("Daniel Radcliffe"), findActorByName("Emma Watson"), findActorByName("Rupert Grint")),
                Set.of("Adventure", "Fantasy"), Year.of(2004)));

        movies.add(new Movie(54, "Harry Potter and the Goblet of Fire", Set.of(findDirectorByName("Mike Newell")),
                Set.of(findActorByName("Daniel Radcliffe"), findActorByName("Emma Watson"), findActorByName("Rupert Grint")),
                Set.of("Adventure", "Fantasy"), Year.of(2005)));

        movies.add(new Movie(55, "Harry Potter and the Order of the Phoenix", Set.of(findDirectorByName("David Yates")),
                Set.of(findActorByName("Daniel Radcliffe"), findActorByName("Emma Watson"), findActorByName("Rupert Grint")),
                Set.of("Adventure", "Fantasy"), Year.of(2007)));

        movies.add(new Movie(56, "Harry Potter and the Half-Blood Prince", Set.of(findDirectorByName("David Yates")),
                Set.of(findActorByName("Daniel Radcliffe"), findActorByName("Emma Watson"), findActorByName("Rupert Grint")),
                Set.of("Adventure", "Fantasy"), Year.of(2009)));

        movies.add(new Movie(57, "Harry Potter and the Deathly Hallows – Part 1", Set.of(findDirectorByName("David Yates")),
                Set.of(findActorByName("Daniel Radcliffe"), findActorByName("Emma Watson"), findActorByName("Rupert Grint")),
                Set.of("Adventure", "Fantasy"), Year.of(2010)));

        movies.add(new Movie(58, "Harry Potter and the Deathly Hallows – Part 2", Set.of(findDirectorByName("David Yates")),
                Set.of(findActorByName("Daniel Radcliffe"), findActorByName("Emma Watson"), findActorByName("Rupert Grint")),
                Set.of("Adventure", "Fantasy"), Year.of(2011)));

        movies.add(new Movie(59, "La vita è bella", Set.of(findDirectorByName("Roberto Benigni")),
                Set.of(findActorByName("Roberto Benigni"), findActorByName("Nicoletta Braschi"), findActorByName("Giorgio Cantarini")),
                Set.of("Comedy", "Drama", "War"), Year.of(1997)));

        movies.add(new Movie(60, "The Truman Show", Set.of(findDirectorByName("Peter Weir")),
                Set.of(findActorByName("Jim Carrey"), findActorByName("Laura Linney"), findActorByName("Ed Harris")),
                Set.of("Comedy", "Drama", "Sci-Fi"), Year.of(1998)));

        movies.add(new Movie(61, "The Green Mile", Set.of(findDirectorByName("Frank Darabont")),
                Set.of(findActorByName("Tom Hanks"), findActorByName("Michael Clarke Duncan"), findActorByName("David Morse")),
                Set.of("Crime", "Drama", "Fantasy"), Year.of(1999)));

        movies.add(new Movie(62, "The Pianist", Set.of(findDirectorByName("Roman Polanski")),
                Set.of(findActorByName("Adrien Brody"), findActorByName("Thomas Kretschmann"), findActorByName("Frank Finlay")),
                Set.of("Biography", "Drama", "War"), Year.of(2002)));

        movies.add(new Movie(63, "The Prestige", Set.of(findDirectorByName("Christopher Nolan")),
                Set.of(findActorByName("Christian Bale"), findActorByName("Hugh Jackman"), findActorByName("Scarlett Johansson")),
                Set.of("Drama", "Mystery", "Sci-Fi"), Year.of(2006)));

        movies.add(new Movie(64, "The Curious Case of Benjamin Button", Set.of(findDirectorByName("David Fincher")),
                Set.of(findActorByName("Brad Pitt"), findActorByName("Cate Blanchett"), findActorByName("Tilda Swinton")),
                Set.of("Drama", "Fantasy", "Romance"), Year.of(2008)));

        movies.add(new Movie(65, "Slumdog Millionaire", Set.of(findDirectorByName("Danny Boyle")),
                Set.of(findActorByName("Dev Patel"), findActorByName("Freida Pinto"), findActorByName("Anil Kapoor")),
                Set.of("Drama", "Romance"), Year.of(2008)));

        movies.add(new Movie(66, "The King's Speech", Set.of(findDirectorByName("Tom Hooper")),
                Set.of(findActorByName("Colin Firth"), findActorByName("Geoffrey Rush"), findActorByName("Helena Bonham Carter")),
                Set.of("Biography", "Drama", "History"), Year.of(2010)));

        movies.add(new Movie(67, "The Help", Set.of(findDirectorByName("Tate Taylor")),
                Set.of(findActorByName("Emma Stone"), findActorByName("Viola Davis"), findActorByName("Octavia Spencer")),
                Set.of("Drama"), Year.of(2011)));

        movies.add(new Movie(68, "Life of Pi", Set.of(findDirectorByName("Ang Lee")),
                Set.of(findActorByName("Suraj Sharma"), findActorByName("Irrfan Khan"), findActorByName("Adil Hussain")),
                Set.of("Adventure", "Drama", "Fantasy"), Year.of(2012)));

        movies.add(new Movie(69, "12 Years a Slave", Set.of(findDirectorByName("Steve McQueen")),
                Set.of(findActorByName("Chiwetel Ejiofor"), findActorByName("Michael Fassbender"), findActorByName("Lupita Nyong'o")),
                Set.of("Biography", "Drama", "History"), Year.of(2013)));

        movies.add(new Movie(70, "The Theory of Everything", Set.of(findDirectorByName("James Marsh")),
                Set.of(findActorByName("Eddie Redmayne"), findActorByName("Felicity Jones"), findActorByName("Tom Prior")),
                Set.of("Biography", "Drama", "Romance"), Year.of(2014)));

        movies.add(new Movie(71, "The Imitation Game", Set.of(findDirectorByName("Morten Tyldum")),
                Set.of(findActorByName("Benedict Cumberbatch"), findActorByName("Keira Knightley"), findActorByName("Matthew Goode")),
                Set.of("Biography", "Drama", "Thriller"), Year.of(2014)));

        movies.add(new Movie(72, "The Fault in Our Stars", Set.of(findDirectorByName("Josh Boone")),
                Set.of(findActorByName("Shailene Woodley"), findActorByName("Ansel Elgort"), findActorByName("Nat Wolff")),
                Set.of("Drama", "Romance"), Year.of(2014)));

        movies.add(new Movie(73, "The Secret Life of Walter Mitty", Set.of(findDirectorByName("Ben Stiller")),
                Set.of(findActorByName("Ben Stiller"), findActorByName("Kristen Wiig"), findActorByName("Shirley MacLaine")),
                Set.of("Adventure", "Comedy", "Drama"), Year.of(2013)));

        movies.add(new Movie(74, "The Great Gatsby", Set.of(findDirectorByName("Baz Luhrmann")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Carey Mulligan"), findActorByName("Tobey Maguire")),
                Set.of("Drama", "Romance"), Year.of(2013)));

        movies.add(new Movie(75, "Gone Girl", Set.of(findDirectorByName("David Fincher")),
                Set.of(findActorByName("Ben Affleck"), findActorByName("Rosamund Pike"), findActorByName("Neil Patrick Harris")),
                Set.of("Drama", "Mystery", "Thriller"), Year.of(2014)));

        movies.add(new Movie(76, "The Grand Budapest Hotel", Set.of(findDirectorByName("Wes Anderson")),
                Set.of(findActorByName("Ralph Fiennes"), findActorByName("F. Murray Abraham"), findActorByName("Mathieu Amalric")),
                Set.of("Adventure", "Comedy", "Drama"), Year.of(2014)));

        movies.add(new Movie(77, "The Revenant", Set.of(findDirectorByName("Alejandro González Iñárritu")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Tom Hardy"), findActorByName("Will Poulter")),
                Set.of("Adventure", "Drama", "Thriller"), Year.of(2015)));

        movies.add(new Movie(78, "Spotlight", Set.of(findDirectorByName("Tom McCarthy")),
                Set.of(findActorByName("Mark Ruffalo"), findActorByName("Michael Keaton"), findActorByName("Rachel McAdams")),
                Set.of("Biography", "Crime", "Drama"), Year.of(2015)));

        movies.add(new Movie(79, "The Danish Girl", Set.of(findDirectorByName("Tom Hooper")),
                Set.of(findActorByName("Eddie Redmayne"), findActorByName("Alicia Vikander"), findActorByName("Ben Whishaw")),
                Set.of("Biography", "Drama", "History"), Year.of(2015)));

        movies.add(new Movie(80, "The Shape of Water", Set.of(findDirectorByName("Guillermo del Toro")),
                Set.of(findActorByName("Sally Hawkins"), findActorByName("Michael Shannon"), findActorByName("Richard Jenkins")),
                Set.of("Adventure", "Drama", "Fantasy"), Year.of(2017)));

        movies.add(new Movie(81, "Three Billboards Outside Ebbing, Missouri", Set.of(findDirectorByName("Martin McDonagh")),
                Set.of(findActorByName("Frances McDormand"), findActorByName("Woody Harrelson"), findActorByName("Sam Rockwell")),
                Set.of("Crime", "Drama"), Year.of(2017)));

        movies.add(new Movie(82, "Call Me by Your Name", Set.of(findDirectorByName("Luca Guadagnino")),
                Set.of(findActorByName("Timothée Chalamet"), findActorByName("Armie Hammer"), findActorByName("Michael Stuhlbarg")),
                Set.of("Drama", "Romance"), Year.of(2017)));

        movies.add(new Movie(83, "A Star is Born", Set.of(findDirectorByName("Bradley Cooper")),
                Set.of(findActorByName("Lady Gaga"), findActorByName("Bradley Cooper"), findActorByName("Sam Elliott")),
                Set.of("Drama", "Music", "Romance"), Year.of(2018)));

        movies.add(new Movie(84, "Bohemian Rhapsody", Set.of(findDirectorByName("Bryan Singer")),
                Set.of(findActorByName("Rami Malek"), findActorByName("Lucy Boynton"), findActorByName("Gwilym Lee")),
                Set.of("Biography", "Drama", "Music"), Year.of(2018)));

        movies.add(new Movie(85, "Joker", Set.of(findDirectorByName("Todd Phillips")),
                Set.of(findActorByName("Joaquin Phoenix"), findActorByName("Robert De Niro"), findActorByName("Zazie Beetz")),
                Set.of("Crime", "Drama", "Thriller"), Year.of(2019)));

        movies.add(new Movie(86, "1917", Set.of(findDirectorByName("Sam Mendes")),
                Set.of(findActorByName("George MacKay"), findActorByName("Dean-Charles Chapman"), findActorByName("Mark Strong")),
                Set.of("Drama", "War"), Year.of(2019)));

        movies.add(new Movie(87, "Parasite", Set.of(findDirectorByName("Bong Joon-ho")),
                Set.of(findActorByName("Song Kang-ho"), findActorByName("Lee Sun-kyun"), findActorByName("Cho Yeo-jeong")),
                Set.of("Comedy", "Drama", "Thriller"), Year.of(2019)));

        movies.add(new Movie(88, "Little Women", Set.of(findDirectorByName("Greta Gerwig")),
                Set.of(findActorByName("Saoirse Ronan"), findActorByName("Emma Watson"), findActorByName("Florence Pugh")),
                Set.of("Drama", "Romance"), Year.of(2019)));

        movies.add(new Movie(89, "The Irishman", Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Robert De Niro"), findActorByName("Al Pacino"), findActorByName("Joe Pesci")),
                Set.of("Biography", "Crime", "Drama"), Year.of(2019)));

        movies.add(new Movie(90, "Knives Out", Set.of(findDirectorByName("Rian Johnson")),
                Set.of(findActorByName("Daniel Craig"), findActorByName("Chris Evans"), findActorByName("Ana de Armas")),
                Set.of("Comedy", "Crime", "Drama"), Year.of(2019)));

        movies.add(new Movie(91, "Tenet", Set.of(findDirectorByName("Christopher Nolan")),
                Set.of(findActorByName("John David Washington"), findActorByName("Robert Pattinson"), findActorByName("Elizabeth Debicki")),
                Set.of("Action", "Sci-Fi", "Thriller"), Year.of(2020)));

        movies.add(new Movie(92, "Nomadland", Set.of(findDirectorByName("Chloé Zhao")),
                Set.of(findActorByName("Frances McDormand"), findActorByName("David Strathairn"), findActorByName("Linda May")),
                Set.of("Drama"), Year.of(2020)));

        movies.add(new Movie(93, "Dune", Set.of(findDirectorByName("Denis Villeneuve")),
                Set.of(findActorByName("Timothée Chalamet"), findActorByName("Rebecca Ferguson"), findActorByName("Oscar Isaac")),
                Set.of("Action", "Adventure", "Drama"), Year.of(2021)));

        movies.add(new Movie(94, "The Power of the Dog", Set.of(findDirectorByName("Jane Campion")),
                Set.of(findActorByName("Benedict Cumberbatch"), findActorByName("Kirsten Dunst"), findActorByName("Jesse Plemons")),
                Set.of("Drama", "Western"), Year.of(2021)));

        movies.add(new Movie(95, "CODA", Set.of(findDirectorByName("Sian Heder")),
                Set.of(findActorByName("Emilia Jones"), findActorByName("Marlee Matlin"), findActorByName("Troy Kotsur")),
                Set.of("Drama", "Music"), Year.of(2021)));

        movies.add(new Movie(96, "Everything Everywhere All at Once", Set.of(findDirectorByName("Daniel Kwan"), findDirectorByName("Daniel Scheinert")),
                Set.of(findActorByName("Michelle Yeoh"), findActorByName("Stephanie Hsu"), findActorByName("Ke Huy Quan")),
                Set.of("Action", "Adventure", "Comedy"), Year.of(2022)));

        movies.add(new Movie(97, "The Batman", Set.of(findDirectorByName("Matt Reeves")),
                Set.of(findActorByName("Robert Pattinson"), findActorByName("Zoë Kravitz"), findActorByName("Paul Dano")),
                Set.of("Action", "Crime", "Drama"), Year.of(2022)));

        movies.add(new Movie(98, "Top Gun: Maverick", Set.of(findDirectorByName("Joseph Kosinski")),
                Set.of(findActorByName("Tom Cruise"), findActorByName("Miles Teller"), findActorByName("Jennifer Connelly")),
                Set.of("Action", "Drama"), Year.of(2022)));

        movies.add(new Movie(99, "Elvis", Set.of(findDirectorByName("Baz Luhrmann")),
                Set.of(findActorByName("Austin Butler"), findActorByName("Tom Hanks"), findActorByName("Olivia DeJonge")),
                Set.of("Biography", "Drama", "Music"), Year.of(2022)));

        movies.add(new Movie(100, "Avatar: The Way of Water", Set.of(findDirectorByName("James Cameron")),
                Set.of(findActorByName("Sam Worthington"), findActorByName("Zoe Saldana"), findActorByName("Sigourney Weaver")),
                Set.of("Action", "Adventure", "Fantasy"), Year.of(2022)));
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User u) {
        this.currentUser = u;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByUsername(String name) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(name)) {
                return u;
            }
        }
        System.out.println("\nUsuari no trobat");
        return null;
    }

    public boolean checkUser(String checkUser) {
        return users.stream().anyMatch(user -> user.getUsername().equals(checkUser));
    }

    public boolean checkPassword(String checkUser, String checkPasswd) {
        return users.stream()
                .filter(user -> user.getUsername().equals(checkUser))
                .anyMatch(user -> user.getPassword().equals(checkPasswd));
    }

    public void showAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void removeUserById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public LinkedHashSet<Movie> filterMovies(String query) {
        String finalQuery = query.toLowerCase();
        System.out.println();
        return movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(finalQuery) ||
                        movie.getYear().toString().contains(finalQuery) ||
                        movie.getDirectors().stream().anyMatch(d -> d.getName().toLowerCase().contains(finalQuery)) ||
                        movie.getActors().stream().anyMatch(a -> a.getName().toLowerCase().contains(finalQuery)) ||
                        movie.getGenre().stream().anyMatch(g -> g.toLowerCase().contains(finalQuery)))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public void listMovies() {
        movies.forEach(movie -> System.out.println("  - " + movie.getTitle() + " (" + movie.getYear() + ")"));
        System.out.println();
    }

    public void addFriend(User currentUser, User foundUser) {
        foundUser.addPendingFriend(currentUser);
    }

    public boolean areTheyFriends(User currentUser, User foundUser) {
        return currentUser.getFriends().contains(foundUser) && foundUser.getFriends().contains(currentUser);
    }

    public void displayFoundProfile(User u) {
        System.out.print(u.getUsername() + " " + u.getMail());
    }

    public void displayFoundProfileList(ArrayList<User> users) {
        int n = 0;
        for (User u : users) {
            n += 1;
            System.out.println(n + " - " + u.getUsername());
        }
    }

    public void acceptFriendRequest(User acceptedUser) {
        currentUser.getPendingFR().remove(acceptedUser);
        currentUser.getFriends().add(acceptedUser);
        acceptedUser.getFriends().add(currentUser);
    }

    @Override
    public String toString() {
        return "RecomenderManager{" +
                "movies=" + movies +
                ", users=" + users +
                '}';
    }
}