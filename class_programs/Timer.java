import java.io.*;

class Time
{
	byte hh;
	byte mm;
	byte ss;

	Time()
	{
		hh = mm = ss = 0;
	}

	Time(byte hh,byte mm,byte ss)
	{
		this.hh = hh;
		this.mm = mm;
		this.ss = ss;
	}

	Time addTime(Time val)
	{
		Time set = new Time();

		set.ss = (byte)(ss + val.ss);
		if(set.ss >= 60)
		{
			set.ss = (byte)(set.ss - 60);
			set.mm++;
		}

		set.mm = (byte)(mm + val.mm);
		if(set.mm >= 60)
		{
			set.mm = (byte)(set.mm - 60);
			set.hh++;
		}

		set.hh = (byte)(this.hh + val.hh);
		return set;

	}
}

class Timer
{
	public static void main(String []args)
	{
		Time t1 = new Time((byte)1, (byte)15, (byte)50);
		Time t2 = new Time((byte)2, (byte)35, (byte)35);
		Time t3 = t1.addTime(t2);

		System.out.println("Total time is:" + t3.hh + ":" + t3.mm + ":" + t3.ss);
	}
}