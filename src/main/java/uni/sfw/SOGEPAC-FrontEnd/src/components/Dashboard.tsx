// src/components/Dashboard.tsx

import React from "react";
import {
	Box,
	Grid,
	Card,
	CardContent,
	Typography,
	IconButton,
} from "@mui/material";
import HistoryIcon from "@mui/icons-material/History";
import SearchIcon from "@mui/icons-material/Search";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import PersonSearchIcon from "@mui/icons-material/PersonSearch";
import EmergencyIcon from "@mui/icons-material/Warning";

const Dashboard: React.FC = () => {
	return (
		<Box
			sx={{
				padding: "20px",
				backgroundColor: "#e0f7fa",
				minHeight: "100vh",
			}}
		>
			<Box
				sx={{
					backgroundColor: "#90caf9",
					padding: "40px",
					textAlign: "center",
					borderRadius: "10px",
				}}
			>
				<Typography
					variant="h2"
					sx={{ color: "#fff", fontWeight: "bold" }}
				>
					SOGEPAC
				</Typography>
				<Typography variant="h6" sx={{ color: "#fff" }}>
					Better systems, Better lives
				</Typography>
			</Box>
			<Grid container spacing={3} sx={{ marginTop: "20px" }}>
				<Grid item xs={12} md={4}>
					<Card sx={{ textAlign: "center", padding: "20px" }}>
						<CardContent>
							<IconButton>
								<HistoryIcon fontSize="large" />
							</IconButton>
							<Typography variant="h5">
								Generar historial clínico
							</Typography>
						</CardContent>
					</Card>
				</Grid>
				<Grid item xs={12} md={4}>
					<Card sx={{ textAlign: "center", padding: "20px" }}>
						<CardContent>
							<IconButton>
								<SearchIcon fontSize="large" />
							</IconButton>
							<Typography variant="h5">
								Buscar historial clínico
							</Typography>
						</CardContent>
					</Card>
				</Grid>
				<Grid item xs={12} md={4}>
					<Card sx={{ textAlign: "center", padding: "20px" }}>
						<CardContent>
							<IconButton>
								<PersonSearchIcon fontSize="large" />
							</IconButton>
							<Typography variant="h5">
								Buscar doctores
							</Typography>
						</CardContent>
					</Card>
				</Grid>
				<Grid item xs={12} md={4}>
					<Card sx={{ textAlign: "center", padding: "20px" }}>
						<CardContent>
							<IconButton>
								<PersonAddIcon fontSize="large" />
							</IconButton>
							<Typography variant="h5">
								Agregar paciente
							</Typography>
						</CardContent>
					</Card>
				</Grid>
				<Grid item xs={12} md={4}>
					<Card sx={{ textAlign: "center", padding: "20px" }}>
						<CardContent>
							<IconButton>
								<PersonSearchIcon fontSize="large" />
							</IconButton>
							<Typography variant="h5">
								Buscar paciente
							</Typography>
						</CardContent>
					</Card>
				</Grid>
				<Grid item xs={12} md={4}>
					<Card sx={{ textAlign: "center", padding: "20px" }}>
						<CardContent>
							<IconButton>
								<EmergencyIcon fontSize="large" />
							</IconButton>
							<Typography variant="h5">
								Crear orden de emergencia
							</Typography>
						</CardContent>
					</Card>
				</Grid>
			</Grid>
		</Box>
	);
};

export default Dashboard;
