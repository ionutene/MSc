package project.getBoundedPaths;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Combinations {
    private Set<String> keys;
    private Set<Set<String>> originalElements;
    private Set<Set<String>> finalElements;

    public Combinations(Set<String> keys) {
        this.keys = keys;
        this.originalElements = new LinkedHashSet<>();
        this.finalElements = new LinkedHashSet<>();
        initOriginalElements();
    }

    public static void main(String[] args) {
        Combinations combinations = null;
        try {
            combinations = new Combinations(CSVParser.readWithCsvMapReader().keySet());
            combinations.initOriginalElements();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int index = 1; index <= 3; index++) {
            Set<Set<String>> result = combinations.getAllCombinations(combinations.getOriginalElements(), index);
            System.out.println("=========");
            result.stream().forEach(e -> System.out.println(e));
        }
    }

    private void initOriginalElements() {
        for (String key : keys) {
            Set<String> tempSet = new LinkedHashSet<>();
            tempSet.add(key);
            originalElements.add(tempSet);
        }
    }

    public void doAllNonRepetitiveCombinationsBetweenIndices(int startPoint, int endPoint) {
        for (int index = startPoint; index <= endPoint; index++) {
            Set<Set<String>> result = getAllCombinations(getOriginalElements(), index);
            if (result.size() == 0) {
                break;
            }
            finalElements.addAll(result);
        }
    }

    public Set<Set<String>> getOriginalElements() {
        return originalElements;
    }

    public Set<Set<String>> getFinalElements() {
        return finalElements;
    }

    private Set<Set<String>> getAllCombinations(Set<Set<String>> originalElements, int lengthOfList) {
        Set<Set<String>> allElements = new LinkedHashSet<>();
        if (lengthOfList == 1) return originalElements;
        else {
            Set<Set<String>> allSubElements = getAllCombinations(originalElements, lengthOfList - 1);
            for (Set<String> element : originalElements) {
                for (Set<String> subElement : allSubElements) {
                    Set<String> interimSet = new LinkedHashSet<>();
                    interimSet.addAll(element);
                    interimSet.addAll(subElement);
                    if (interimSet.size() == lengthOfList) {
                        allElements.add(interimSet);
                    }
                }
            }
            return allElements;
        }
    }
}
