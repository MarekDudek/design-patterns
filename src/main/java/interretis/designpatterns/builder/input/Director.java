package interretis.designpatterns.builder.input;

import interretis.designpatterns.builder.api.Builder;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import lombok.AllArgsConstructor;

import com.google.common.io.Files;

@AllArgsConstructor
public class Director {

    private File file;
    private Builder builder;
    private Charset charset;

    public void construct() throws Exception
    {
	final List<String> lines = Files.readLines(file, charset);

	for (final String line : lines)
	{
	    if (line.startsWith("\t\t")) {
		builder.levelThree(line.trim());
	    } else if (line.startsWith("\t")) {
		builder.levelTwo(line.trim());
	    } else {
		builder.levelOne(line.trim());
	    }
	}
    }
}
