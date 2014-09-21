package interretis.designpatterns.factorymethod.api;

public interface PartFactory {

    Part makeTopLevelPart();
    
    Part makePart(Part parent);
    
    Part makeBottomLevelPart(Part parent);
}
