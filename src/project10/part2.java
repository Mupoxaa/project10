package project10;

import java.util.Scanner;

// custom class
class AnimeItem {
    private String title;
    private String genre;
    private int episodes;
    private double rating; // Numeric property for sorting

    // Constructor to initialize properties
    public AnimeItem(String title, String genre, int episodes, double rating) {
        this.title = title;
        this.genre = genre;
        this.episodes = episodes;
        this.rating = rating;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getEpisodes() { return episodes; }
    public double getRating() { return rating; }

    public void printDetails() {
        System.out.println("Title: " + title + " | Genre: " + genre + " | Episodes: " + episodes + " | Rating: " + rating);
    }
}


// custom collection
class AnimeCollection {
    // 1. Private property count to store number of elements
    private int count;

    // 2. Private array to store objects
    private AnimeItem[] animes;

    // Constructor to set array capacity
    public AnimeCollection(int capacity) {
        this.count = 0;
        this.animes = new AnimeItem[capacity];
    }

    // 3. add(newObj) method to add new items
    public void add(AnimeItem newObj) {
        if (count < animes.length) {
            animes[count] = newObj;
            count++;
        } else {
            System.out.println("Collection is full!");
        }
    }

    // 4. printOne(int i) method and print() method
    public void printOne(int i) {
        if (i >= 0 && i < count) {
            System.out.print("Index " + i + " -> ");
            animes[i].printDetails();
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void print() {
        if (count == 0) {
            System.out.println("Collection is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            printOne(i);
        }
    }

    // 5. find(String s) method to search by string field (title)
    public void find(String s) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (animes[i].getTitle().equalsIgnoreCase(s)) {
                printOne(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No anime found with title: " + s);
        }
    }

    // 6. sort() method to perform bubble sort based on numeric property (rating)
    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                // Descending order: highest rating first
                if (animes[j].getRating() < animes[j + 1].getRating()) {
                    AnimeItem temp = animes[j];
                    animes[j] = animes[j + 1];
                    animes[j + 1] = temp;
                }
            }
        }
        System.out.println("Collection successfully sorted by rating!");
    }

    // 7. Other method for search objects by additional properties (genre and episodes)
    public void findByGenreAndEpisodes(String genre, int episodes) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (animes[i].getGenre().equalsIgnoreCase(genre) && animes[i].getEpisodes() == episodes) {
                printOne(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No anime found matching this genre and episodes count.");
        }
    }
}

public class part2 {
    public static void main(String[] args) {
        AnimeCollection collection = new AnimeCollection(50);
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Pre-fill with a couple of items so the list isn't empty at start
        collection.add(new AnimeItem("Attack on Titan", "Dark Fantasy", 89, 9.1));
        collection.add(new AnimeItem("Death Note", "Thriller", 37, 9.0));

        while (choice != 0) {
            System.out.println("Welcome to the anime database");
            System.out.println("Choose an option:");
            System.out.println("1 - add anime to collection");
            System.out.println("2 - print all anime");
            System.out.println("3 - sort anime by rating");
            System.out.println("4 - search anime by title");
            System.out.println("5 - search anime by genre and episodes");
            System.out.println("0 - exit the program");
            System.out.print("Your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                if (choice == 1) {
                    inputItems(collection, scanner);
                } else if (choice == 2) {
                    collection.print();
                } else if (choice == 3) {
                    collection.sort();
                } else if (choice == 4) {
                    search(collection, scanner);
                } else if (choice == 5) {
                    searchAdditional(collection, scanner);
                } else if (choice == 0) {
                    System.out.println("Exiting program");
                } else {
                    System.out.println("Invalid option, please choose between 0 and 5.");
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.nextLine(); // clear invalid input
            }
        }
        scanner.close();
    }

    // method to input new items with stop option
    public static void inputItems(AnimeCollection collection, Scanner scanner) {
        String stop = "";
        while (!stop.equalsIgnoreCase("stop")) {
            System.out.print("Enter title (or type 'stop' to finish): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();

            System.out.print("Enter episodes count: ");
            int episodes = scanner.nextInt();

            System.out.print("Enter rating (e.g. 8.5): ");
            double rating = scanner.nextDouble();
            scanner.nextLine(); // clear buffer

            collection.add(new AnimeItem(title, genre, episodes, rating));
            System.out.println("Anime added successfully!");

            System.out.print("Type 'stop' to finish input or press Enter to add another: ");
            stop = scanner.nextLine();
        }
    }

    // method to search by title
    public static void search(AnimeCollection collection, Scanner scanner) {
        System.out.print("Enter anime title to search: ");
        String title = scanner.nextLine();
        collection.find(title);
    }

    // method to search by additional properties (genre + episodes)
    public static void searchAdditional(AnimeCollection collection, Scanner scanner) {
        System.out.print("Enter genre to search: ");
        String genre = scanner.nextLine();
        System.out.print("Enter exact episodes count: ");
        int episodes = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        collection.findByGenreAndEpisodes(genre, episodes);
    }
}
