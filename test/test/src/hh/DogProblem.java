package hh;

public class DogProblem {
    public static Dog[] largerThanFourNeighbors(Dog[] dogs) {
        Dog[] returnDogs = new Dog[dogs.length];
        int cnt = 0;

        for (int i = 0; i < dogs.length; i++) {
            if (isBiggestOfFour(dogs, i)) {
                returnDogs[cnt] = dogs[i];
                cnt++;
            }
        }
        returnDogs = arrayWithNoNulls(returnDogs, cnt);
        return returnDogs;
    }

    public static Dog[] arrayWithNoNulls(Dog[] dogs, int cnt) {
        Dog[] noNullDogs = new Dog[cnt];
        for (int i = 0; i < cnt; i++) {
            noNullDogs[i] = dogs[i];
        }
        return noNullDogs;
    }

    public static boolean isBiggestOfFour(Dog[] dogs, int i) {
        boolean isBiggest = true;
        for (int j = -2; j <= 2; j++) {
            int compareIndex = i + j;

            // Avoid comparing ourselves to ourselves
            if (j == 0) {
                continue;
            }
            if (validIndex(dogs, compareIndex)) {
                if (dogs[compareIndex].weightInPounds >= dogs[i].weightInPounds) {
                    isBiggest = false;
                }
            }
        }
        return isBiggest;
    }

    public static boolean validIndex(Dog[] dogs, int i) {
        return i >= 0 && i < dogs.length;
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{
                new Dog(10),
                new Dog(15),
                new Dog(20),
                new Dog(15),
                new Dog(10),
                new Dog(5),
                new Dog(10),
                new Dog(15),
                new Dog(22),
                new Dog(15),
                new Dog(20)
        };
        Dog[] bigDogs1 = largerThanFourNeighbors(dogs);

        for (int k = 0; k < bigDogs1.length; k++) {
            System.out.print(bigDogs1[k].weightInPounds + " ");
        }
    }
}

class Dog {
    int weightInPounds;

    Dog(int weight) {
        this.weightInPounds = weight;
    }
}
