package logic;

import render.IRenderable;

public abstract class Entity implements IRenderable{
	protected int x,y;
	protected int z;
	protected boolean visible, destroyed;
	
	public Entity() {
		visible = true;
		destroyed = false;
	}
	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visible;
	}
	
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return destroyed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (destroyed != other.destroyed)
			return false;
		if (visible != other.visible)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Entity [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
