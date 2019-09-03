package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 *  Tests methods add, replace, delete.
 */

public class StartUITest {
	private final PrintStream stdout = System.out;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();


	@Before
	public void loadOutput() {
		System.setOut(new PrintStream(this.out));
	}

	@After
	public void backOutput() {
		System.setOut(this.stdout);
	}

	/**
	 * Test showAllItem.
	 */

	@Test
	public void whenFindAllThenShowAll() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("test name", "desc", 123L));
		Item item1 = tracker.add(new Item("test name1", "desc", 124L));
		Input input = new StubInput(new String[] {"1", "6"});
		StartUI startUI = new StartUI(input, tracker);
		startUI.init();
		assertThat(
				this.out.toString(),
				is(	new StringBuilder()
									.append(showMenu())
									.append("---" + item.getId() + "---" + item.getName() + "---" + item.getDecs() + System.lineSeparator())
									.append("---" + item1.getId() + "---" + item1.getName() + "---" + item1.getDecs() + System.lineSeparator())
									.append(showMenu())
									.toString()
			)
		);
	}

	/**
	 * Test findById.
	 */

	@Test
	public void whenFindByIdThenItemById() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("test name", "desc", 123L));
		Input input = new StubInput(new String[] {"4", item.getId(), "6"});
		new StartUI(input, tracker).init();
		assertThat(
				this.out.toString(),
				is(
						new StringBuilder()
								.append(showMenu())
								.append("---------------Ищем по id-------------" + System.lineSeparator())
								.append("---" + item.getId() + "---" + item.getName() + "---" + item.getDecs() + System.lineSeparator())
								.append(showMenu())
								.toString()
			)
		);
	}

	/**
	 * Test FindByName.
	 */

	@Test
	public  void whenFindByNameThanItemByName() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("test name", "desc", 123L));
		Input input = new StubInput((new String[] {"5", item.getName(), "6"}));
		new StartUI(input, tracker).init();
		assertThat(
				this.out.toString(),
				is(
						new StringBuilder()
									.append(showMenu())
									.append("---------------Ищем по имени-------------" + System.lineSeparator())
									.append("---" + item.getId() + "---" + item.getName() + "---" + item.getDecs() + System.lineSeparator())
									.append(showMenu())
									.toString()
				)
		);
	}


    /**
    * Test method add.
    */

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
		Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
    *Test method replace. 
    */
    
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
		Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "replace the application", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    
    /**
    *Test method delete.
    */

    @Test
    public void whenDeleteAloneItemThenTrackerIsEmpty() {
		Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
		assertThat(tracker.findAll().length, is(0));
    }



    public String showMenu() {

    	StringBuilder menu = new StringBuilder();
    	menu.append("0. Add the new item" + System.lineSeparator());
    	menu.append("1. Show all items" + System.lineSeparator());
    	menu.append("2. Edit item" + System.lineSeparator());
    	menu.append("3. Delete item" + System.lineSeparator());
    	menu.append("4. Find item by id" + System.lineSeparator());
    	menu.append("5. Find item by name" + System.lineSeparator());
    	menu.append(("6. Exit program" + System.lineSeparator()));
    	return menu.toString();
    }
}
