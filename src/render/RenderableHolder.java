package render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	//Collection4IRenderable
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image hallSprite;
	public static Image cellSprite;
	public static Image canteenSprite;
	public static Image fieldSprite;
	public static Image maintainanceSprite;
	public static Image outsideSprite;
	public static Image toiletSprite;
	public static Image tunnelSprite;
	public static Image playerSpriteR;
	public static Image playerSpriteL;
	public static Image playerSpriteB;
	public static Image berosSprite;
	public static Image scorfieldSprite;
	public static Image policeSprite;
	public static Image nightSprite;
    public static Image burgerSprite;
    public static Image shovelSprite;
    public static Image keySprite;
    public static Image knifeSprite;
    public static Image ladderSprite;
    public static Image deathSprite;
    public static Image escapSprite;
    public static Image tutorial1Sprite;
    public static Image tutorial2Sprite;
    public static Image moonSprite;
    //Audio
    public static AudioClip objectCatchSound;
    public static AudioClip killSound;
    public static AudioClip winSound;
    public static AudioClip beginSound;
    public static AudioClip invenSound;
    public static AudioClip inSound;
    
	static {
		loadResource();
	}
	
	public static void loadResource() {
		hallSprite = new Image(ClassLoader.getSystemResource("scene/hall.png").toString());
		cellSprite = new Image(ClassLoader.getSystemResource("scene/cell.png").toString());
		canteenSprite = new Image(ClassLoader.getSystemResource("scene/canteen.png").toString());
		fieldSprite = new Image(ClassLoader.getSystemResource("scene/field.png").toString());
		maintainanceSprite = new Image(ClassLoader.getSystemResource("scene/maintainance.png").toString());
		outsideSprite = new Image(ClassLoader.getSystemResource("scene/outside.png").toString());
		toiletSprite = new Image(ClassLoader.getSystemResource("scene/toilet.png").toString());
		tunnelSprite = new Image(ClassLoader.getSystemResource("scene/tunnel.png").toString());
		//player
		playerSpriteR = new Image(ClassLoader.getSystemResource("right.png").toString());
		playerSpriteL = new Image(ClassLoader.getSystemResource("left.png").toString());
		playerSpriteB = new Image(ClassLoader.getSystemResource("backwards.png").toString());
		//NPC
		berosSprite = new Image(ClassLoader.getSystemResource("Beros.png").toString());
		scorfieldSprite = new Image(ClassLoader.getSystemResource("Scorfield.png").toString());
		policeSprite = new Image(ClassLoader.getSystemResource("Policeman.png").toString());		
        burgerSprite = new Image(ClassLoader.getSystemResource("tools/Burger.png").toString());
        shovelSprite = new Image(ClassLoader.getSystemResource("tools/Shovel.png").toString());
        keySprite = new Image(ClassLoader.getSystemResource("tools/Key.png").toString());
        knifeSprite = new Image(ClassLoader.getSystemResource("tools/Knife.png").toString());
        ladderSprite = new Image(ClassLoader.getSystemResource("tools/Ladder.png").toString());
        moonSprite = new Image(ClassLoader.getSystemResource("shinning.png").toString());
        //extension
        nightSprite = new Image(ClassLoader.getSystemResource("scene/night.png").toString());
        deathSprite = new Image(ClassLoader.getSystemResource("scene/death.png").toString());
        escapSprite = new Image(ClassLoader.getSystemResource("scene/Escapist.png").toString());
        tutorial1Sprite = new Image(ClassLoader.getSystemResource("scene/tutorial1.png").toString());
        tutorial2Sprite = new Image(ClassLoader.getSystemResource("scene/tutorial2.png").toString());
        //Audio
        objectCatchSound = new AudioClip(ClassLoader.getSystemResource("audio/objectcatch.wav").toString());
        killSound = new AudioClip(ClassLoader.getSystemResource("audio/kill.wav").toString());
        winSound = new AudioClip(ClassLoader.getSystemResource("audio/libre.wav").toString());
        beginSound = new AudioClip(ClassLoader.getSystemResource("audio/beginning.wav").toString());
        invenSound = new AudioClip(ClassLoader.getSystemResource("audio/backspace.wav").toString());
        inSound = new AudioClip(ClassLoader.getSystemResource("audio/prison.mp3").toString());
	}
	
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) ->{
			if(o1.getZ() < o2.getZ()) return 1;
			return -1;
		};
	}
	//organize all object we draw
	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
	}
	
	public void update() {
		for(int i = entities.size()-1; i >= 0; i--) {
			if(entities.get(i).isDestroyed()) {
				entities.remove(i);
			}
		}
	}
	public static RenderableHolder getInstance() {
		return instance;
	}
	
	public List<IRenderable> getEntities(){
		return entities;
	}

	public Comparator<IRenderable> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<IRenderable> comparator) {
		this.comparator = comparator;
	}

	public void setEntities(List<IRenderable> entities) {
		this.entities = entities;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RenderableHolder other = (RenderableHolder) obj;
		if (comparator == null) {
			if (other.comparator != null)
				return false;
		} else if (!comparator.equals(other.comparator))
			return false;
		if (entities == null) {
			if (other.entities != null)
				return false;
		} else if (!entities.equals(other.entities))
			return false;
		return true;
	}
	
	
}
