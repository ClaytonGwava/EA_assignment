package cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String redirectBook() {return "redirect:/books";}

    @GetMapping("/books")
    public String getAll(Model model){
        model.addAttribute("books", new ArrayList<Book>());
        return "bookList";
    }

    @PostMapping("/books")
    public String add(Book book) {
        bookService.add(book);
        return "redirect:/books";
    }
    @GetMapping("/books/add")
    public String viewAdd(@ModelAttribute Book book, Model model){
        model.addAttribute("msg","Add");
        return "bookDetail";
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model){
        model.addAttribute("book", bookService.get(id));
        model.addAttribute("msg", "Update");
        return "bookDetail";
    }

    @PostMapping("books/{id}")
    public String update(Book book, @PathVariable int id){
        bookService.update(book);
        return "redirect:/books";
    }

    @PostMapping(value="/books/delete")
    public String delete(int bookId){
        bookService.delete(bookId);
        return "redirect:/books";
    }
}
