package ga;

import java.util.Random;

public class GeneRandomizer {

	public String getRandomProtocolType(){
	/* Return random protocol type. */
		String[] protocol = new String[3]; 
		protocol[0] = "tcp";
		protocol[1] = "icmp";
		protocol[2] = "udp";
		return protocol[new Random().nextInt(3)];
	}
	
	public String getRandomService(){
	/* Return random service. */
		String[] services = new String[65]; 
		services[0]  = "IRC";
		services[1]  = "X11";
		services[2]  = "Z39_50";
		services[3]  = "auth";
		services[4]  = "bgp";
		services[5]  = "courier";
		services[6]  = "csnet_ns";
		services[7]  = "ctf";
		services[8]  = "daytime";
		services[9]  = "discard";
		services[10]  = "domain";
		services[11]  = "domain_u";
		services[12]  = "echo";
		services[13]  = "eco_i";
		services[14]  = "ecr_i";
		services[15]  = "efs";
		services[16]  = "exec";
		services[17]  = "finger";
		services[18]  = "ftp";
		services[19]  = "ftp_data";
		services[20]  = "gopher";
		services[21]  = "hostnames";
		services[22]  = "http";
		services[23]  = "http_443";
		services[24]  = "icmp";
		services[25]  = "imap4";
		services[26]  = "iso_tsap";
		services[27]  = "klogin";
		services[28]  = "kshell";
		services[29]  = "ldap";
		services[30]  = "link";
		services[31]  = "login";
		services[32]  = "mtp";
		services[33]  = "name";
		services[34]  = "netbios_dgm";
		services[35]  = "netbios_ns";
		services[36]  = "netbios_ssn";
		services[37]  = "netstat";
		services[38]  = "nnsp";
		services[39]  = "nntp";
		services[40]  = "ntp_u";
		services[41]  = "other";
		services[42]  = "pm_dump";
		services[43]  = "pop_2";
		services[44]  = "pop_3";
		services[45]  = "printer";
		services[46]  = "private";
		services[47]  = "remote_job";
		services[48]  = "rje";
		services[49]  = "shell";
		services[50]  = "smtp";
		services[51]  = "sql_net";
		services[52]  = "ssh";
		services[53]  = "sunrpc";
		services[54]  = "supdup";
		services[55]  = "systat";
		services[56]  = "telnet";
		services[57]  = "tftp_u";
		services[58]  = "tim_i";
		services[59]  = "time";
		services[60]  = "urp_i";
		services[61]  = "uucp";
		services[62]  = "uucp_path";
		services[63]  = "vmnet";
		services[64]  = "whois";
		return services[new Random().nextInt(65)];
	}
		
	public int getRandomSourcePort(){
	/* Valid port is from 0-65535. */
		return new Random().nextInt(65536);
	}
	
	public int getRandomDestinationPort(){
	/* Valid port is from 0-65535. */
		return new Random().nextInt(65536);
	}

	public int getRandomDuration(){
	/* Duration is in terms of secs. and 33, 333, 333 secs is more than one year. This should be enough. */
		return new Random().nextInt(33333333);
	}
	
	public int getRandomSourceBytes(){
	/* Gives random size of bytes sent by the source. */
		return new Random().nextInt(999999999);
	}
	
	public int getRandomDestinationBytes(){
	/* Gives random size of bytes sent by the destination. */
		return new Random().nextInt(999999999);
	}
	
	public int getRandomLanding(){
	/* Gives random instance whether the source and destination ports are the same. */
		return new Random().nextInt(2);
	}
}

