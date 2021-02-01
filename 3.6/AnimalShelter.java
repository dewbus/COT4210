/**
 * Louis Alvarez
 * Animal Shelter maintains a queue of dogs or cats and is able to enqueue, dequeue either, dequeue dog, and
 * deque cat.
 * LM: 1/31/2021
 * Cracking the Coding Interview : Chapter 3
 * Question 3.6
 */

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    /**
     * Class main creats an object AnimalShelterQueue and enqueues (3) dogs and (3) cats in that order.
     * Then dequeues (1) dog and (1) cat. Finally it dequeues the class AnimalShelterQueue until all animals
     * are adopted.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        AnimalShelterQueue animalshelter = new AnimalShelterQueue();

        animalshelter.enqueue(new Dog());
        animalshelter.enqueue(new Dog());
        animalshelter.enqueue(new Dog());

        animalshelter.enqueue(new Cat());
        animalshelter.enqueue(new Cat());
        animalshelter.enqueue(new Cat());

        animalshelter.dequeueDog();
        System.out.printf("There are %d dogs remaining.", animalshelter.dogs.size());

        animalshelter.dequeueCat();
        System.out.printf("\nThere are %d cats remaining.", animalshelter.cats.size());

        int animalSize = animalshelter.dogs.size() + animalshelter.cats.size();
        for(int i = 0; i < animalSize; i++){
            System.out.printf("\nThere are %d animals remaining.", animalSize - i);
            animalshelter.dequeueAny();
        }
    }
}

/**
 * Parent class animal extends to class dog and class cat. Contains string animal which stores the type of animal
 */
class Animal{
    String animal;
}

/**
 * Subclass Dog is an extension of class Animal.
 */
class Dog extends Animal{
    Dog(){
        super();
        animal = "dog";
    }
}

/**
 * Subclass Cat is an extension of class Animal.
 */
class Cat extends Animal{
    Cat(){
        super();
        animal = "cat";
    }
}

/**
 * Class AnimalShelterQueue contains two attributes, queue dogs/cat. Its functions allow for adding to and maintaining
 * both queues.
 */
class AnimalShelterQueue{
    Queue dogs;
    Queue cats;

    public AnimalShelterQueue(){ //Constructor
        dogs = new LinkedList<Dog>();
        cats = new LinkedList<Cat>();
    }

    /**
     * Adds animal to appropriate queue.
     * @param animal Either class dog or cat.
     * @throws Exception If animal is not dog or cat, throws exception.
     */
    public void enqueue(Animal animal) throws Exception{
        if(animal.animal.equals("dog")){
            dogs.offer((Dog) animal);
        } else if(animal.animal.equals("cat")){
            cats.offer((Cat) animal);
        } else{
            throw new Exception("Animal type not supported.");
        }
    }

    /**
     * Checks if either queue is empty and returns animal from non empty queue.
     * @return Animal
     * @throws Exception If both queues are empty, returns exception.
     */
    public Animal dequeueAny() throws Exception{
        boolean noDog = dogs.isEmpty();
        boolean noCat = cats.isEmpty();
        if(noDog && noCat){
            throw new Exception("Animal shelter is vacant!");
        }

        if(noCat){
            return (Animal)dogs.poll();
        } else if(noDog){
            return (Animal)cats.poll();
        }

        return (Animal)dogs.poll();
    }

    /**
     * Checks if dog queue is empty and returns a dog from dog queue.
     * @return Dog
     * @throws Exception If queue is empty, returns exception.
     */
    public Dog dequeueDog() throws Exception{
        boolean noDog = dogs.isEmpty();
        if(noDog){
            throw new Exception("There aren't any dogs.");
        }
        return (Dog)dogs.poll();
    }

    /**
     * Checks if cat queue is empty and returns a cat from cat queue.
     * @return Cat
     * @throws Exception If queue is empty, returns exception.
     */
    public Cat dequeueCat() throws Exception{
        boolean noCat = dogs.isEmpty();
        if(noCat){
            throw new Exception("There aren't any cats.");
        }
        return (Cat)cats.poll();
    }
}

