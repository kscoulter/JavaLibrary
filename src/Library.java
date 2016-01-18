import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class Library {
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION){
			try {
				Workbook library = new HSSFWorkbook(new FileInputStream(fileChooser.getSelectedFile()));
				System.out.println("Enter the category or 'all' to see all books in the library: ");
				Scanner in = new Scanner(System.in);
				String category = in.nextLine();
				Sheet sheet = library.getSheetAt(0);
				ArrayList<Book> books = new ArrayList<Book>();
				Set<String> uniqueCat = new TreeSet<String>();
				
				for(Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();){
					Row row = rit.next();
					if(row.getRowNum()== 0){
						continue;
					}
					System.out.println();
					if(row.getCell(2).toString().equalsIgnoreCase("Non-Fiction")){
						Nonfiction nfbook = new Nonfiction();
						nfbook.id = row.getCell(0).toString();	
						nfbook.title = row.getCell(1).toString();
						nfbook.category = row.getCell(3).toString();
						nfbook.author = row.getCell(4).toString();
						nfbook.numPages = row.getCell(5).toString();
						nfbook.dewey = row.getCell(6).toString();
						uniqueCat.add(nfbook.category = row.getCell(3).toString());
						books.add(nfbook);
					}
					else if(row.getCell(2).toString().equalsIgnoreCase("Fiction")){
						Fiction fbook = new Fiction();
						fbook.id = row.getCell(0).toString();	
						fbook.title = row.getCell(1).toString();
						fbook.category = row.getCell(3).toString();
						fbook.author = row.getCell(4).toString();
						fbook.numPages = row.getCell(5).toString();
						uniqueCat.add(fbook.category = row.getCell(3).toString());
						books.add(fbook);
					}
					else{
						Book book = new Book();
						book.id = row.getCell(0).toString();	
						book.title = row.getCell(1).toString();
						book.category = row.getCell(2).toString();
						book.author = row.getCell(3).toString();
						book.numPages = row.getCell(4).toString();
						uniqueCat.add(book.category = row.getCell(3).toString());
						books.add(book);
					}
				
				}
				Collections.sort(books);
				
				
					if(category.equals("all")){
						System.out.print("Total number of books: " + books.size());
						System.out.println();
						System.out.print("Total number of categories: " + uniqueCat.size());
						System.out.println();
						for(String c : uniqueCat){
							System.out.println(c);
						}
					}
					for(int i = 0; i< books.size(); i++){
						if(books.get(i).category.toLowerCase().equals(category.toLowerCase())){
							if(books.get(i).getClass().toString().equalsIgnoreCase("class Fiction")){
								System.out.print("ID: " + books.get(i).id);
								System.out.println();
								System.out.print("Book Title: " + books.get(i).title);
								System.out.println();
								System.out.print("Category: " + books.get(i).category);
								System.out.println();
								System.out.print("Author: " + books.get(i).author);
								System.out.println();
								System.out.print("Number of Pages: " + books.get(i).numPages);
								System.out.println();
								System.out.println();
								System.out.println();
							}
							else if(books.get(i).getClass().toString().equalsIgnoreCase("class Nonfiction")){
								System.out.print("ID: " + books.get(i).id);
								System.out.println();
								System.out.print("Dewey #: " + ((Nonfiction) books.get(i)).getDewey());
								System.out.println();
								System.out.print("Book Title: " + books.get(i).title);
								System.out.println();
								System.out.print("Category: " + books.get(i).category);
								System.out.println();
								System.out.print("Author: " + books.get(i).author);
								System.out.println();
								System.out.print("Number of Pages: " + books.get(i).numPages);
								System.out.println();
								System.out.println();
								System.out.println();
							}
						}
							
					}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
