package decorator.importdb;

public interface IEntry {

	int getCursor();
	int getTotal();
	void entry(String strFile) throws Exception;
}
