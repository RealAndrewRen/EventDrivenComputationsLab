import java.util.LinkedList;
import java.util.TreeSet;

public class MailServer extends LinkedList<Message> {
	private TreeSet<Actor> set;

	public MailServer() {
		set = new TreeSet<Actor>();
	}

	public void signUp(Actor actor) {
		set.add(actor);
	}

	public void dispatch(Message msg) {
		if (msg.getRecipient() == null) {
			for (Actor x : set) {
				if (!x.getName().equals(msg.getSender().getName())) {
					x.receive(msg);
				}
			}
		} else {
			msg.getRecipient().receive(msg);
		}
	}
}
