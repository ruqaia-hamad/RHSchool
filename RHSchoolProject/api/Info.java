package api;

import java.io.Serializable;

public class Info implements Serializable{
	private String seeds;
	private Integer results;
	private Integer page;
	private String version;

	public String getSeeds() {
		return seeds;
	}

	public void setSeeds(String seeds) {
		this.seeds = seeds;
	}

	public Integer getResults() {
		return results;
	}

	public void setResults(Integer results) {
		this.results = results;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
