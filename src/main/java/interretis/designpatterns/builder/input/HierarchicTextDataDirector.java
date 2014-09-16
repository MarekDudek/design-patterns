package interretis.designpatterns.builder.input;

import interretis.designpatterns.builder.api.Builder;
import interretis.designpatterns.builder.api.Director;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import lombok.AllArgsConstructor;

import com.google.common.io.Files;

@AllArgsConstructor
public class HierarchicTextDataDirector implements Director {

    private File file;
    private Builder builder;
    private Charset charset;

    @Override
    public void construct() throws Exception
    {
	final List<String> lines = Files.readLines(file, charset);

	for (final String line : lines)
	{
	    final String trimmed = line.trim();

	    if (line.startsWith("\t\t\t"))
	    {
		builder.levelFour(trimmed);
	    }
	    else if (line.startsWith("\t\t"))
	    {
		builder.levelThree(trimmed);
	    }
	    else if (line.startsWith("\t"))
	    {
		builder.levelTwo(trimmed);
	    }
	    else
	    {
		builder.levelOne(trimmed);
	    }
	}
    }
}
