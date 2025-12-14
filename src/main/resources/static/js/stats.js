function formatUptime(seconds) {
    const days = Math.floor(seconds / 86400);
    seconds %= 86400;

    const hours = Math.floor(seconds / 3600);
    seconds %= 3600;

    const minutes = Math.floor(seconds / 60);
    seconds %= 60;

    if (days>0) {return `${days}d ${hours}h ${minutes}m`;}
    if (hours>0) {return `${hours}h ${minutes}m ${seconds}s`;}
    if (minutes>0) {return `${minutes}m ${seconds}s`;}
    return `${seconds}s`;
}

function showMemory(memory) {
    document.getElementById("freeMem").textContent = memory.freeRAM + " GB";
    document.getElementById("usedMem").textContent = memory.usedRAM + " GB";
    document.getElementById("totalMem").textContent = memory.totalRAM + " GB";
}

function showCPU(cpu) {
    document.getElementById("processCpu").textContent = cpu.cpuProcessLoad + "%";
    document.getElementById("systemCpu").textContent = cpu.cpuSystemLoad + "%";
    document.getElementById("totalCpu").textContent = cpu.cpuTotalLoad + "%";
}

function showDisk(disk) {
    document.getElementById("totalDisk").textContent = disk.totalDisk + " GB";
    document.getElementById("freeDisk").textContent = disk.freeDisk + " GB";
}

function showUptime(uptimeS) {
    document.getElementById("uptime").textContent = formatUptime(uptimeS);
}

async function loadStats() {
    const response = await fetch("/api/stats");
    const data = await response.json();

    showMemory(data.allMemory);
    showCPU(data.allCPU);
    showDisk(data.allDisk);
    showUptime(data.allUptime.uptime);
}

loadStats();