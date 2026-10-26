package linkdata;

import java.util.*;
import java.util.stream.Collectors;

public abstract class DataLinker<T1, T2, K, R> {
    // a implémenter par chaque linker
    protected abstract K getLeftKey(T1 left);
    protected abstract K getRightKey(T2 right);
    protected abstract R createResult(T1 left, T2 right);

    // liaison entre les deux collections et transforme chaque paire en objet R
    public List<R> link(Collection<T1> leftList, Collection<T2> rightList) {
        // on indexe la seconde liste par sa cle
        Map<K, T2> rightMap = rightList.stream()
                .filter(item -> getRightKey(item) != null)
                .collect(Collectors.toMap(
                        this::getRightKey,
                        item -> item,
                        (existing, replacement) -> existing // en cas de doublon
                ));

        // on associe avec la première liste et on transforme en R
        return leftList.stream()
                .filter(item -> getLeftKey(item) != null && rightMap.containsKey(getLeftKey(item)))
                .map(item -> createResult(item, rightMap.get(getLeftKey(item))))
                .toList();
    }
}
