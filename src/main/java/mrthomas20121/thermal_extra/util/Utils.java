package mrthomas20121.thermal_extra.util;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utils {

    /**
     * credit to the tfc devs for this method
     * Creates a map of each enum constant to the value as provided by the value mapper.
     */
    public static <E extends Enum<E>, V> EnumMap<E, V> mapOfKeys(Class<E> enumClass, Function<E, V> valueMapper)
    {
        return mapOfKeys(enumClass, key -> true, valueMapper);
    }

    /**
     * credit to the tfc devs for this method
     * Creates a map of each enum constant to the value as provided by the value mapper, only using enum constants that match the provided predicate.
     */
    public static <E extends Enum<E>, V> EnumMap<E, V> mapOfKeys(Class<E> enumClass, Predicate<E> keyPredicate, Function<E, V> valueMapper)
    {
        return Arrays.stream(enumClass.getEnumConstants()).filter(keyPredicate).collect(Collectors.toMap(Function.identity(), valueMapper, (v, v2) -> v, () -> new EnumMap<>(enumClass)));
    }
}
