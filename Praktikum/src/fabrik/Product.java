package fabrik;

import java.io.IOException;

public abstract class Product {
	public abstract String[] leseausDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
