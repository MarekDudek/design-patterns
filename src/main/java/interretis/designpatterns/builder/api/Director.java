package interretis.designpatterns.builder.api;

import java.util.List;

public interface Director {

    void construct(List<String> lines);
}
