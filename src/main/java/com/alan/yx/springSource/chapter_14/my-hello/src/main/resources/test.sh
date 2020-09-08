#!/usr/bin/env bash

args=1
if [ $# -eq 1 ];then
	args=$1
	echo "The argument is: $args"
fi

echo "This is a $call"
start=`date +%s`
sleep 3s
end=`date +%s`
cost=$((($end - $start) * $args * $val))
