package bridge.post;

public class ThingManage {

	AbstractThing thing;

	AbstractThing createThing(String thingName) throws Exception {
		thing = (AbstractThing) Class.forName(thingName).newInstance();
		return thing;
	}

}
