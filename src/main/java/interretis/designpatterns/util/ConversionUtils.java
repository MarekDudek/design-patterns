package interretis.designpatterns.util;

import java.util.List;

public class ConversionUtils {

    @SuppressWarnings("unchecked")
    public static <TYPE> List<TYPE> genericise(List<?> list)
    {
	return (List<TYPE>) list;
    }
}
