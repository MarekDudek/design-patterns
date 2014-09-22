package interretis.designpatterns.adapter.api;

import java.util.List;

public interface Part {

    Part getParent();

    List<Part> getChildren();
}
