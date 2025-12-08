async function loadStats() {
    const response = await fetch("/api/stats");
    const data = await response.json();

    document.getElementById("totalMem").textContent = data.memory.totalRAM;

}

loadStats();