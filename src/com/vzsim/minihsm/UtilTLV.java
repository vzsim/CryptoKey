package com.vzsim.minihsm;

public class UtilTLV
{
	protected static byte
	tlvGetLen(byte[] buff, final short start, final short length, final byte tag)
	{
		for (short off = start; off < length; ++off) {
			if (buff[off] == tag) {
				return buff[++off];
			}
			off++;
			off += buff[off];
		}

		return (byte)-1;
	}

	protected static short
	tlvGetValue(byte[] buff, final short start, final short length, final byte tag)
	{
		for (short off = start; off < length; ++off) {
			if (buff[off] == tag) {
				return (short)(off + (short)2);
			}
			off++;
			off += buff[off];
		}

		return (short)-1;
	}
}
