
public class Book implements Comparable<Book> {
	public String category;
	public String id;
	public String title;
	public String numPages;
	public String author;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int compareTo(Book book)
	{
		return this.title.compareTo(book.getTitle());
	}
}
