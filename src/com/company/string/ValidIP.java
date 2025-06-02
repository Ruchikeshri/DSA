package com.company.string;

import java.util.*;

public class ValidIP {

    public static List<Integer> getRegions(List<String> ips){
        List<Integer> regions = new ArrayList<>();

        for(String ip: ips){
            if(ip == null || ip.isEmpty()){
                regions.add(-1);
                continue;
            }

            if(ip.contains(".")){
                validIPv4(ip,regions);
            }
        }

        return regions;
    }

    private static void validIPv4(String ip, List<Integer> region) {

        String parts[] = ip.split("\\.");
        if(parts.length !=4) {
            region.add(-1);
            return;
        }

        int firstOctet =-1;
        boolean isValid = true;
        for(int i=0;i<4;i++){
            String part = parts[i];
            if(part.isEmpty() || (part.length()>1 &&
                                  part.startsWith("0"))) {
                region.add(-1);
                return;
            }

            try{
               int value = Integer.parseInt(part);
                if(value < 0 || value > 255) {
                    isValid = false;
                    break;
                }
               if(i ==0){
                   firstOctet = value;
               }

            }catch(Exception e){
                isValid = false;
                break;
            }
        }
        if(!isValid){
            region.add(-1);
        } else {
            if(firstOctet>=0 && firstOctet<=127){
                region.add(1);
            } else if(firstOctet >=128 && firstOctet<=191){
                region.add(2);
            } else if(firstOctet>=192 && firstOctet<=223){
                region.add(3);
            } else if(firstOctet>=224 && firstOctet<=239){
                region.add(4);
            } else if(firstOctet>=240 && firstOctet<= 255){
                region.add(5);
            }else {
                region.add(-1);
            }
        }
    }

    public static void main(String[] args) {
        // Sample IPs to test
        List<String> ips = Arrays.asList("192.168.1.1", "255.255.255.255", "128.0.0.1", "300.200.100.50", "10.10.10.10");

        // Get regions
        List<Integer> regions = getRegions(ips);

        // Print the results
        System.out.println("Regions for the given IPs: " + regions);
    }

}
