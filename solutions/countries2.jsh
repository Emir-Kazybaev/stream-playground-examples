import countries.*;
var countries = new Countries().getAll();


//1.
countries.stream().anyMatch(country -> country.getName().toLowerCase().contains("island"))

//2.
countries.stream().filter(country -> country.getName().toLowerCase().contains("island")).map(Country::getName).findFirst().get()

//3.
countries.stream().filter(country -> country.getName().toLowerCase().charAt(0) == country.getName().toLowerCase().charAt(country.getName().length()-1)).map(Country::getName).forEach(System.out::println)

//4.
countries.stream().mapToLong(Country::getPopulation).sorted().limit(10).forEach(System.out::println)

//5.
countries.stream().sorted(Comparator.comparingLong(Country::getPopulation)).limit(10).map(Country::getName).forEach(System.out::println)

//6.

countries.stream().mapToInt(country -> country.getTranslations().size()).summaryStatistics()

//7.

countries.stream().sorted(Comparator.comparing(country -> country.getTimezones().size())).map(Country::getName).forEach(System.out::println);

//8.
countries.stream().sorted(Comparator.comparing(country -> country.getTimezones().size())).forEach(country -> System.out.println(country.getName() + ": " + country.getPopulation()))

//9.
countries.stream().filter(country -> !country.getTranslations().containsKey("es")).map(Country::getName).count()


//10.

countries.stream().filter(country -> country.getArea() == null).map(Country::getName).forEach(System.out::println)

//11.---------------

countries.stream().flatMap(country -> country.getTranslations()).distinct().sorted().forEach(System.out::println)

//12.

countries.stream().mapToInt(country -> country.getName().length()).sum()/countries.stream().count()

countries.stream().mapToInt(country -> country.getName().length()).sum()/(double)countries.stream().count()

//13.

countries.stream().filter(country -> country.getArea()==null).map(Country::getRegion).distinct().forEach(System.out::println)

//14.

countries.stream().filter(country -> country.getArea() != null).max(Comparator.comparing(country ->country.getArea())).get()

//15.
countries.stream().filter(country -> country.getArea() != null && country.getArea().compareTo(BigDecimal.TEN)<0).map(Country::getName).forEach(System.out::println)

//16.
countries.stream().filter(country -> country.getRegion() == Region.EUROPE || country.getRegion() == Region.ASIA).flatMap(country -> country.getTimezones().stream()).distinct().forEach(System.out::println)
